-- Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
--
-- WSO2 Inc. licenses this file to you under the Apache License,
-- Version 2.0 (the "License"); you may not use this file except
-- in compliance with the License.
-- You may obtain a copy of the License at
--
-- http://www.apache.org/licenses/LICENSE-2.0
--
-- Unless required by applicable law or agreed to in writing,
-- software distributed under the License is distributed on an
-- "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
-- KIND, either express or implied. See the License for the
-- specific language governing permissions and limitations
-- under the License.

---------- PURPOSE ------------
-- This script facilitates user authentication for a update site backed with NGINX. It allows updates to be downloaded only for WSO2 subscription customers using their username and password.

----------- USAGE -------------
-- 1. Define the access block as below inside the update location in nginx.conf configuration file.
-- location /update {
--     autoindex on;
--     access_by_lua_file path/to/lua-auth.lua;
-- }
-- 2. Set <WSO2-token-endpoint-auth-token> in TOKEN_EP_BASIC_AUTH_TOKEN and launch the NGINX server.

local https = require("ssl.https")
local ltn12 = require("ltn12")

-- URL encoder
local function urlencode(str)
    str = string.gsub(str, "([^0-9a-zA-Z !'()*._~-])", -- locale independent
    function(c)
        return string.format("%%%02X", string.byte(c))
    end)
    str = string.gsub(str, " ", "+")
    return str
end

-- Obtain an access token from WSO2 Token API for the user_email and user_password
local function getAccessToken(user_email, user_password)
    print("getting access token")
    local TOKEN_EP = "https://gateway.api.cloud.wso2.com/token"
    local TOKEN_EP_BASIC_AUTH_TOKEN =
        "Basic <WSO2-token-endpoint-auth-token>"

    local url = TOKEN_EP .. "?grant_type=client_credentials&username=" .. urlencode(user_email .. "@updateslive") ..
                    "&password=" .. urlencode(user_password)
    local token_ep_headers = {}
    token_ep_headers["Authorization"] = TOKEN_EP_BASIC_AUTH_TOKEN
    token_ep_headers["Content-Type"] = "application/x-www-form-urlencoded"

    local token_ep_response = {}
    local body, code, headers, status = https.request {
        url = url,
        method = "POST",
        headers = token_ep_headers,
        sink = ltn12.sink.table(token_ep_response)
    }

    if code ~= 200 then
        return nil
    end

    token_ep_response = table.concat(token_ep_response)
    local access_token = token_ep_response:match('"access_token":"([%w-]+)"')

    -- print("access token:" .. access_token)

    return access_token

end

-- Check WSO2 subscription status of the user
local function isSubscribed(user_email, access_token)
    local SUBSCRIPTION_EP =
        "https://gateway.api.cloud.wso2.com/t/updateslive/channels/3.0.0/user-prod-subscription/wso2am/full"
    local url = SUBSCRIPTION_EP .. "?email=" .. user_email
    local subscription_ep_headers = {}
    subscription_ep_headers["Authorization"] = "Bearer " .. access_token
    subscription_ep_headers["Cookie"] = "SERVERID=s0"
    local subscription_ep_response = {}
    local body, code, headers, status = https.request {
        url = url,
        method = "GET",
        headers = subscription_ep_headers,
        sink = ltn12.sink.table(subscription_ep_response)
    }

    subscription_ep_response = table.concat(subscription_ep_response)
    local is_subscribed = subscription_ep_response:match('"is%-subscribed":(%w+)')

    -- print(is_subscribed)

    return is_subscribed
end


-- Extract user email and password from base64 encoded autorization code sent from integration studio
local function getCredentials(auth_header)
    if auth_header == nil or auth_header:find(" ") == nil then
        return false
    end

    local divider = auth_header:find(" ")
    if auth_header:sub(0, divider - 1) ~= "Basic" then
        return false
    end

    local user_credentials = ngx.decode_base64(auth_header:sub(divider + 1))
    if user_credentials == nil or user_credentials:find(":") == nil then
        return false
    end

    divider = user_credentials:find(":")
    local user_email = user_credentials:sub(0, divider - 1)
    local user_password = user_credentials:sub(divider + 1)

    return user_email, user_password
end

local function authenticate()
    local auth_header = ngx.req.get_headers()["Authorization"]
    local user_email, user_password = getCredentials(auth_header)

    local access_token = getAccessToken(user_email, user_password)

    if access_token == nil then
        return false
    end

    return isSubscribed(user_email, access_token)
end

local authorized = authenticate()

if not authorized then
    ngx.header.content_type = "text/plain"
    ngx.header.www_authenticate = 'Basic realm=""'
    ngx.status = ngx.HTTP_UNAUTHORIZED
    ngx.say('401 Access Denied')
end

package com.acme.shoppingcart.security.pwcb;

import org.apache.ws.security.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class PWCBHandler implements CallbackHandler {

    public void handle(Callback[] callbacks) throws IOException,
                                                    UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            WSPasswordCallback pwcb = (WSPasswordCallback) callbacks[i];
            String id = pwcb.getIdentifer();
            int usage = pwcb.getUsage();
            if (usage == WSPasswordCallback.USERNAME_TOKEN) {
                // Logic to get the password to build the username token
                if ("admin".equals(id)) {
                    pwcb.setPassword("admin");
                }
            } else if (usage == WSPasswordCallback.SIGNATURE || usage == WSPasswordCallback.DECRYPT) {
                // Logic to get the private key password for signture or decryption
                if ("wso2carbon".equals(id)) {
                    pwcb.setPassword("wso2carbon");
                }
                if ("service".equals(id)) {
                    pwcb.setPassword("apache");
                }
            }
        }
    }

}

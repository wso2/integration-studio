package org.wso2.developerstudio.eclipse.esb.cloud.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HTTPClientUtil {
//    private CookieStore cookieStore;
//    private static HTTPClientUtil instance;
//
//    private HTTPClientUtil(){
//        cookieStore = new BasicCookieStore();
//    }
//
//    public static HTTPClientUtil getHTTPClient(){
//        if (instance == null){
//            instance = new HTTPClientUtil();
//        }
//        return instance;
//    }

    public String sendGet(String url){

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        StringBuffer result = new StringBuffer();

        // add request header
        HttpResponse response = null;
        try {
            response = client.execute(request);

            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static String sendPostWithFormData(String url, Map<String, String> headers, Map<String, String> params, CookieStore cookieStore){

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        StringBuffer result = new StringBuffer();

        for (Map.Entry<String, String> header : headers.entrySet()) {
            post.setHeader(header.getKey(), header.getValue());
        }

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> param : params.entrySet()) {
            urlParameters.add(new BasicNameValuePair(param.getKey(), param.getValue()));
        }
        post.setConfig(RequestConfig
                .custom()
                .setCookieSpec(CookieSpecs.STANDARD)
                .build());
        try {
            post.setEntity(new UrlEncodedFormEntity(urlParameters));

            HttpClientContext context = new HttpClientContext();
//            context.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);

            context.setCookieStore(cookieStore);
            
            System.out.println(context.getCookieStore().getCookies());

            HttpResponse response = client.execute(post, context);
            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            cookieStore = context.getCookieStore();

            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            
            System.out.println("Result" + result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public static String sendPostWithMulipartFormData(String url, Map<String, String> params, Map<String, String> files, CookieStore cookieStore){

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
//        post.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_FORM_URLENCODED.toString());

        StringBuffer result = new StringBuffer();
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        try {

            for (Map.Entry<String, String> param : params.entrySet()) {
                builder.addTextBody(param.getKey(), param.getValue());
            }
            
            for (Map.Entry<String, String> file : files.entrySet()) {
                builder.addPart(file.getKey(), new FileBody(new File(file.getValue())));
            }

//            for (String file : files) {
//                System.out.println(file);
//                
////                builder.addBinaryBody("fileupload", new File(file));
//            }

            HttpEntity entity = builder.build();
            post.setEntity(entity);

            HttpClientContext context = new HttpClientContext();
            context.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);

            HttpResponse response = client.execute(post, context);

            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());

            BufferedReader rd1 = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line1 = "";
            while ((line1 = rd1.readLine()) != null) {
                result.append(line1);
            }
        } catch (IOException e){

        }

        return result.toString();
    }
}

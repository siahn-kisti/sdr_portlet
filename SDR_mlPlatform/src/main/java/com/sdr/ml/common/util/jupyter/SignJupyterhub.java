package com.sdr.ml.common.util.jupyter;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import javax.portlet.RenderResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class SignJupyterhub {



    public void signout(String jupyter_uri, RenderResponse renderResponse){

        StringBuilder buf = new StringBuilder();
        buf.append("\n <script>");

        buf.append("\n window.onload = function () {");
        buf.append("\n document.getElementById(\"codeViewerIframe\").src = \""+ jupyter_uri +"\"");
        buf.append("\n }");

        buf.append("\n </script>");
        renderResponse.setContentType("text/html");
        PrintWriter out = null;
        try {
            out = renderResponse.getWriter();
            out.println(buf.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void signin(String jupyter_uri, String username, String passwd, RenderResponse renderResponse){

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(jupyter_uri);
        ArrayList<NameValuePair> postParameters;

        try {
            postParameters = new ArrayList<NameValuePair>();
            postParameters.add(new BasicNameValuePair("username", username));
            postParameters.add(new BasicNameValuePair("password", passwd));
            httpPost.setEntity(new UrlEncodedFormEntity(postParameters, "UTF-8"));

            HttpResponse response = httpClient.execute(httpPost);

            for(Header header : response.getAllHeaders()){
                if(header.getName().equals("set-cookie")){

                    String[] cookies = header.getValue().split(";");

                    for(String cookie : cookies){
                        if(cookie.indexOf("jupyter-hub-token") != -1){

                            StringBuilder buf = new StringBuilder();
                            buf.append("\n <script>");
                            buf.append("\n document.cookie=\"");
                            buf.append(cookie.replace("\"","\\\""));
                            buf.append(";  Path=/hub/");
                            buf.append("\"");
                            buf.append("\n </script>");

                            renderResponse.setContentType("text/html");
                            PrintWriter out = renderResponse.getWriter();
                            out.println(buf.toString());

                            break;
                        }
                    }

                    break;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.dcq.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Demo class
 *
 * @author chenqiudai
 * @date 10/04/2018
 */
public class DspHttpClient extends ParamUtils{

    public static InputStream getInputStreamByGet(String domain, String method,
                                                  String[] paramNames, Object[] args) {
        return getInputStreamByGet(getUrl(domain,method,paramNames,args));
    }

    private static InputStream getInputStreamByPost(String url,HashMap params){
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url)
                .openConnection();
            conn.setRequestProperty("user-agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.59 Safari/537.36 115Browser/8.6.1");
            conn.setRequestProperty("upgrade-insecure-requests","1");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = conn.getInputStream();
                return inputStream;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static InputStream getInputStreamByGet(String url){
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url)
                .openConnection();
            conn.setRequestProperty("user-agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.59 Safari/537.36 115Browser/8.6.1");

            conn.setRequestProperty("upgrade-insecure-requests","1");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = conn.getInputStream();
                return inputStream;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    private static String getUrl(String domain, String method,
                                 String[] paramNames, Object[] args) {
        String url = StringUtils.removeEnd(domain,"/") + "/" + method + "?";
        StringBuilder sb = new StringBuilder(url);
        ((Stream<Map.Entry>) getParamMaps(paramNames,args).entrySet().stream() ).forEach(
            (entry)->{
                StringBuilder temp = url.endsWith("?") ?
                    sb.append(entry.getKey() + "=" + entry.getValue()):sb.append("&" + entry.getKey() + "=" + entry.getValue());}
        );
        return StringUtils.removeEnd(sb.toString(),"?");
    }
}

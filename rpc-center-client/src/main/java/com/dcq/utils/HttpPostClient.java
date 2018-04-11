package com.dcq.utils;

import com.alibaba.fastjson.JSON;
import com.dcq.serviceMeta.MetaInformation;
import com.dcq.serviceMeta.RpcTypeEnum;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * Demo class
 *
 * @author chenqiudai
 * @date 11/04/2018
 */
public class HttpPostClient {

    public static String doPost(String url, Map<String,String> map, String charset){
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try{
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            //设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String,String> elem = (Map.Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
            }
            if(list.size() > 0){
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    //http://localhost:8080/rpc/getSerciveForGet?serviceName=abc
    //public static void main(String[] args) throws UnsupportedEncodingException {
    //    register();
    //}
    //
    //private static void getService(){
    //    String url = "http://localhost:8090/rpc/getSercive";
    //    Map<String,String> params = new HashMap<>();
    //    params.put("serviceName","abc");
    //    String result = doPost(url, params,"UTF-8");
    //    System.out.println(URLDecoder.decode(result));
    //}
    //
    //private static void register(){
    //    MetaInformation metaInformation = new MetaInformation();
    //    String url = "http://localhost:8090/rpc/register";
    //    Map<String,String> params = new HashMap<>();
    //    metaInformation.setServiceName("getSampleValue");
    //    metaInformation.setMethodName("getSampleValue");
    //    metaInformation.setIp("127.0.0.1");
    //    metaInformation.setPort(8080);
    //    metaInformation.setDomain("http://localhost:8080/demo/");
    //    metaInformation.setRpcType(RpcTypeEnum.HTTP.getTypeStr());
    //    params.put("metaInformation", JSON.toJSONString(metaInformation));
    //    String result = doPost(url, params,"UTF-8");
    //    System.out.println(URLDecoder.decode(result));
    //}
}

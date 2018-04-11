package com.dcq.utils;

import com.alibaba.fastjson.JSONObject;
import com.dcq.serviceMeta.MetaInformation;
import com.dcq.result.BaseResult;
import com.dcq.serviceMeta.RpcTypeEnum;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author chenqiudai
 * @date 11/04/2018
 */
public class RpcUtils {
    //客户端
    private static String rpcCenter_domain = "http://localhost:8090/rpc/";


    public final static void register(String service){

    }

    public final static MetaInformation getService(String serviceName){
        String url = rpcCenter_domain + "getSercive";
        Map<String,String> params = new HashMap<>();
        params.put("serviceName",serviceName);
        String resultStr = HttpPostClient.doPost(url, params,"UTF-8");
        BaseResult result = JSONObject.parseObject(resultStr,BaseResult.class);
        MetaInformation metaInformation = null;
        if(result.getIsSuccess() == 1){
            JSONObject data = (JSONObject)result.getData();
            metaInformation = data.toJavaObject(MetaInformation.class);
        }
        return metaInformation;
    }



    public static Object callRpc(String methodName, String[] paramNames, Object[] args){
        MetaInformation metaInformation = getService(methodName);
        if(metaInformation != null && RpcTypeEnum.HTTP.getTypeStr().equalsIgnoreCase(metaInformation.getRpcType())){
            return callHttpRpc(metaInformation.getDomain(), metaInformation.getPath(), paramNames, args);
        }
        return null;
    }


    private static Object callHttpRpc(String domain , String path, String[] paramNames, Object[] args){
        InputStream inputStream = DspHttpClient.getInputStreamByGet(domain,path,paramNames,args);
        try {
            return DspHttpClient.streamToString(inputStream);
        } catch (IOException e) {
            return null;
        }
    }
}

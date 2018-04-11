package com.dcq.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Demo class
 *
 * @author chenqiudai
 * @date 11/04/2018
 */
public class ParamUtils {

    protected static Map getParamMaps(String[] paramNames, Object[] args){
        Map map = new HashMap();
        if(paramNames == null||args == null ||paramNames.length != args.length){
            return map;
        }else{
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Stream.of(paramNames).forEach(paramName->map.put(paramName,args[atomicInteger.getAndIncrement()]));
            return map;
        }
    }


    public static String streamToString(InputStream inputStream) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"))){
            StringBuilder sb = new StringBuilder();
            //按行读取并打印
            String line=null;
            while((line=br.readLine())!=null){
                sb.append(line);
            }
            return sb.toString();
        }
    }
}

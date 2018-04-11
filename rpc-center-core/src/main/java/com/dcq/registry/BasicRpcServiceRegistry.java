package com.dcq.registry;

import com.dcq.serviceMeta.MetaInformation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demo class
 *
 * @author chenqiudai
 * @date 11/04/2018
 */
public class BasicRpcServiceRegistry {

    private static Map<String,LinkedHashMap> rpcServiceRegistryMap ;

    public static synchronized void init(){
        rpcServiceRegistryMap = new ConcurrentHashMap<>();
    }

    public static void register(MetaInformation serviceMetaInformation){
        if(serviceMetaInformation != null){
            LinkedHashMap serviceMap = getServiceMap(serviceMetaInformation.getServiceName());
            serviceMap.put(serviceMetaInformation.getServiceName(),serviceMetaInformation);
            getRegistryMap().put(serviceMetaInformation.getServiceName(),serviceMap);
        }
    }

    public static MetaInformation get(String serviceName){
        try{
            LinkedHashMap registryMap = getServiceMap(serviceName);
            if(registryMap != null && registryMap.size()>0){
                return (MetaInformation)((Stream<Map.Entry>)registryMap.entrySet().stream()).limit(1)
                    .map(Map.Entry::getValue).collect(Collectors.toList()).get(0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static Map getRegistryMap(){
        synchronized (BasicRpcServiceRegistry.class){
            if(rpcServiceRegistryMap == null){
                init();
            }
        }
        return rpcServiceRegistryMap;
    }

    private synchronized static LinkedHashMap getServiceMap(String serviceName){
        Map<String,LinkedHashMap> registryMap = getRegistryMap();
        LinkedHashMap serviceMap = registryMap.get(serviceName);
        if(serviceMap == null){
            serviceMap = new LinkedHashMap(10, 0.75f, true);
        }
        return serviceMap;
    }
}

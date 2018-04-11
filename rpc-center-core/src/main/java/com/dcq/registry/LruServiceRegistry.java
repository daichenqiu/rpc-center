package com.dcq.registry;

import com.dcq.serviceMeta.MetaInformation;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Demo class
 *
 * @author chenqiudai
 * @date 11/04/2018
 */
@Component
public class LruServiceRegistry implements ServiceRegistry{

    @Override
    public MetaInformation getService(String serviceName) {
        return BasicRpcServiceRegistry.get(serviceName);
    }

    @Override
    public void registerService(MetaInformation service) {
        BasicRpcServiceRegistry.register(service);
    }
}

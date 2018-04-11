package com.dcq.service.impl;

import com.dcq.registry.ServiceRegistry;
import com.dcq.service.RegistryService;
import com.dcq.serviceMeta.MetaInformation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Demo class
 *
 * @author chenqiudai
 * @date 11/04/2018
 */
@Service
public class RegistryServiceImpl implements RegistryService {

    @Resource
    ServiceRegistry serviceRegistry;

    @Override
    public MetaInformation getService(String serviceName) {
        return serviceRegistry.getService(serviceName);
    }

    @Override
    public void registerService(MetaInformation service) {
        serviceRegistry.registerService(service);
    }
}

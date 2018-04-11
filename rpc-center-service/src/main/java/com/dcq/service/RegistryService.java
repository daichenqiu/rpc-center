package com.dcq.service;

import com.dcq.registry.ServiceRegistry;
import com.dcq.serviceMeta.MetaInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Demo class
 *
 * @author chenqiudai
 * @date 11/04/2018
 */
public interface RegistryService {
    MetaInformation getService(String serviceName);

    void registerService(MetaInformation service);
}

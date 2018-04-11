package com.dcq.registry;

import com.dcq.serviceMeta.MetaInformation;

/**
 * Demo class
 *
 * @author chenqiudai
 * @date 11/04/2018
 */
public interface ServiceRegistry {
    MetaInformation getService(String serviceName);

    void registerService(MetaInformation service);
}

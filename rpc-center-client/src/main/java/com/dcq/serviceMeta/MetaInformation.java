package com.dcq.serviceMeta;

import lombok.Data;

/**
 * Demo class
 *
 * @author chenqiudai
 * @date 11/04/2018
 */
@Data
public class MetaInformation {

    private String rpcType;  //0 TCP 1 HTTP

    private String domain;

    private String ip;

    private int port;

    private String serviceName;

    private String methodName;

    private String path;

    private String httpType;
}

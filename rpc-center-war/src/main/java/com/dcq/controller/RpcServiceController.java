package com.dcq.controller;

import com.alibaba.fastjson.JSON;
import com.dcq.result.BaseResult;
import com.dcq.service.RegistryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dcq.serviceMeta.MetaInformation;

import javax.annotation.Resource;

/**
 * Demo class
 *
 * @author chenqiudai
 * @date 11/04/2018
 */
@RestController
@RequestMapping("/rpc")
public class RpcServiceController {

    @Resource
    RegistryService registryService;

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(@RequestParam(value = "metaInformation", required = true) String metaInformation){
        MetaInformation metaInformationObj = JSON.parseObject(metaInformation,MetaInformation.class);
        registryService.registerService(metaInformationObj);
        BaseResult result = BaseResult.success();
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "getSercive",method = RequestMethod.POST)
    public String getSercive(String serviceName){
        MetaInformation metaInformation = registryService.getService(serviceName);
        BaseResult result = (metaInformation == null) ?
            BaseResult.failure(): BaseResult.success(metaInformation);
        return JSON.toJSONString(result);

    }

    @RequestMapping(value = "getSerciveForGet",method = RequestMethod.GET)
    public String getSerciveForGet(String serviceName){
        return getSercive(serviceName);

    }
}

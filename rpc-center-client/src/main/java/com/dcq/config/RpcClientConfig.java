package com.dcq.config;

import com.dcq.aop.RpcAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这个配置需要在客户端项目里配置，引入rpcAop
 * 服务端提供的client里，可以rpc的service都需要添加@Dsp标签。这些服务会被rpc调用
 */
@Configuration
public class RpcClientConfig {
    @Bean(name = "rpcAop")
    public RpcAop rpcAop() {
        return new RpcAop();
    }
}
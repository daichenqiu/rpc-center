package com.dcq.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@SpringBootApplication(scanBasePackages = {"com.dcq"},
    exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
public class RpcApplication  implements EmbeddedServletContainerCustomizer {
    public static void main(String[] args) {
        SpringApplication.run(RpcApplication.class,args);
        System.out.println("rpc-center started");
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8090);
    }
}


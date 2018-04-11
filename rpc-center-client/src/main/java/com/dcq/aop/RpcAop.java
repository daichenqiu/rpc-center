package com.dcq.aop;

import com.dcq.utils.RpcUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Demo class
 *
 * @author chenqiudai
 * @date 10/04/2018
 */
@Aspect
@Component
public class RpcAop {

    private final String remote_domain = "http://localhost:8080";
    @Pointcut("@within(com.dcq.aop.Dsp)")
    public void doRpc(){}

    @Around("doRpc()")
    public Object arround(ProceedingJoinPoint pjp) {
        //方法环绕start.....
        try {
            MethodSignature methodSignature = (MethodSignature)pjp.getSignature();
            //执行rpc方法返回结果
            return RpcUtils.callRpc(methodSignature.getName(),
                methodSignature.getParameterNames() ,pjp.getArgs());
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}

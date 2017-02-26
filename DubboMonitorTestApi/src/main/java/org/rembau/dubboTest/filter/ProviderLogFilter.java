package org.rembau.dubboTest.filter;

import com.alibaba.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * provider端日志的Filter
 * 
 * @author Administrator
 * 
 */
public class ProviderLogFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(ProviderLogFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result result = null;
        try {
            log.debug("request from {}, params: {}", RpcContext.getContext().getRemoteHost(), invocation);
            result = invoker.invoke(invocation);
            log.debug("response to {}, result: {}", RpcContext.getContext().getRemoteHost(), result);
        } catch (Throwable t) {
            log.warn("Exception in ProviderLogFilter of service({} -> {})", invoker, invocation, t);
        }
        return result;
    }

}
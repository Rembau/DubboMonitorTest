package org.rembau.dubboTest.filter;

import com.alibaba.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 消费者公共Filter
 * 
 * @author Administrator
 * 
 */
public class ConsumerFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(ConsumerFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result result = null;
        try {
            log.debug("request to {}, params: {}", RpcContext.getContext().getRemoteHost(), invocation);
            result = invoker.invoke(invocation);
            log.debug("response from {}, result: {}", RpcContext.getContext().getRemoteHost(), result);
            if (!result.hasException()) {
                Object obj = result.getValue();
            }
        } catch (Throwable t) {
            // log.warn("Exception in ConsumerFilter of service({} -> {})",
            // invoker, invocation, t);
            return new RpcResult(new RuntimeException(t.toString()));
        }
        return result;
    }

}
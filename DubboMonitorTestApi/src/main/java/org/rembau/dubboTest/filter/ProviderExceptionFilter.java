package org.rembau.dubboTest.filter;

import com.alibaba.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 公共异常provider端的Filter
 * 
 * @author Administrator
 * 
 */
public class ProviderExceptionFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(ProviderExceptionFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result result = null;
        try {
            result = invoker.invoke(invocation);
            if (result.hasException()) {
                Throwable exception = result.getException();
                log.error("exception: ", exception);
            }
        } catch (Throwable t) {
            log.warn("Exception in ProviderExceptionFilter of service({} -> {})", invoker, invocation, t);
            return new RpcResult(new RuntimeException(t.toString()));
        }
        return result;
    }

}
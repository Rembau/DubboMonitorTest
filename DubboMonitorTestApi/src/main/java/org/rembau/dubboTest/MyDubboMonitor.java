package org.rembau.dubboTest;

import com.alibaba.dubbo.monitor.MonitorService;
import com.alibaba.dubbo.monitor.dubbo.DubboMonitor;
import com.alibaba.dubbo.rpc.Invoker;

/**
 * Created by rembau on 2017/3/1.
 */
public class MyDubboMonitor extends DubboMonitor {
    public MyDubboMonitor(Invoker<MonitorService> monitorInvoker, MonitorService monitorService) {
        super(monitorInvoker, monitorService);
    }

}

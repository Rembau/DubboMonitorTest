package org.rembau.dubboTest;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.monitor.Monitor;
import com.alibaba.dubbo.monitor.MonitorService;
import com.alibaba.dubbo.monitor.support.AbstractMonitorFactory;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.rpc.ProxyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rembau on 2017/3/1.
 */
public class MyDubboMonitorFactory extends AbstractMonitorFactory {
    private final static Logger logger = LoggerFactory.getLogger(MyDubboMonitorFactory.class);

    private Protocol protocol;
    private ProxyFactory proxyFactory;

    public MyDubboMonitorFactory() {
        protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
        proxyFactory = ExtensionLoader.getExtensionLoader(ProxyFactory.class).getAdaptiveExtension();
    }

    @Override
    protected Monitor createMonitor(URL url) {
        logger.info("创建Monitor，url：{}", url);

        url = url.setProtocol(url.getParameter("protocol", "dubbo"));
        if(url.getPath() == null || url.getPath().length() == 0) {
            url = url.setPath(MonitorService.class.getName());
        }

        String filter = url.getParameter("reference.filter");
        if(filter != null && filter.length() != 0) {
            filter = filter + ",";
        } else {
            filter = "";
        }

        url = url.addParameters(new String[]{"cluster", "failsafe", "check", String.valueOf(false), "reference.filter", filter + "-monitor"});
        Invoker monitorInvoker = this.protocol.refer(MonitorService.class, url);
        MonitorService monitorService = (MonitorService)this.proxyFactory.getProxy(monitorInvoker);
        return new MyDubboMonitor(monitorInvoker, monitorService);
    }
}

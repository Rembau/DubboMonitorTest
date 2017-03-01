package org.rembau.dubboTest;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.monitor.Monitor;
import com.alibaba.dubbo.monitor.MonitorFactory;
import com.alibaba.dubbo.monitor.support.AbstractMonitorFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rembau on 2017/3/1.
 */
public class TestDubboClientTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test1() throws Exception {
        MonitorFactory monitorFactory = ExtensionLoader.getExtensionLoader(MonitorFactory.class).getAdaptiveExtension();
        System.out.println(monitorFactory);
        Monitor monitor = monitorFactory.getMonitor(URL.valueOf("myDubbo://127.0.0.1:40001?interval=10"));
        System.out.println(monitor);

        monitor = monitorFactory.getMonitor(URL.valueOf("dubbo://127.0.0.1:40001?interval=10"));
        System.out.println(monitor);

        System.out.println(AbstractMonitorFactory.getMonitors());
    }

}
package org.rembau.dubboTest;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.monitor.MonitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by rembau on 2017/2/24.
 */
@Service
public class MyDubboMonitorServiceImpl implements MonitorService {
    private final static Logger logger = LoggerFactory.getLogger(MyDubboMonitorServiceImpl.class);

    @Override
    public void collect(URL url) {
        MonitorDataDto monitorDataDto = new MonitorDataDto();
        monitorDataDto.setApplication(url.getParameter("application"));
        monitorDataDto.setConcurrent(url.getParameter("concurrent"));
        monitorDataDto.setConsumer(url.getParameter("consumer"));
        monitorDataDto.setDate(new Date(Long.valueOf(url.getParameter("timestamp"))));
        monitorDataDto.setElapsed(url.getParameter("elapsed"));
        monitorDataDto.setFailure(url.getParameter("failure"));
        monitorDataDto.setHost(url.getHost());
        monitorDataDto.setInput(url.getParameter("input"));
        monitorDataDto.setInterfaceStr(url.getParameter("interface"));
        monitorDataDto.setMaxConcurrent(url.getParameter("max.concurrent"));
        monitorDataDto.setMaxElapsed(url.getParameter("max.elapsed"));
        monitorDataDto.setMaxInput(url.getParameter("max.input"));
        monitorDataDto.setMaxOutput(url.getParameter("max.output"));
        monitorDataDto.setMethod(url.getParameter("method"));
        monitorDataDto.setOutput(url.getParameter("output"));
        monitorDataDto.setPassword(url.getParameter("password"));
        monitorDataDto.setPath(url.getPath());
        monitorDataDto.setPort(url.getPort());
        monitorDataDto.setProtocol(url.getProtocol());
        monitorDataDto.setProvider(url.getParameter("provider"));
        monitorDataDto.setSuccess(url.getParameter("success"));
        monitorDataDto.setTimestamp(url.getParameter("timestamp"));
        monitorDataDto.setUserName(url.getUsername());
        logger.info("接收到统计信息：{}", url);
    }
    //count://192.168.10.107:40001/org.rembau.dubboTest.TestDubboService/sayHello?application=testService&concurrent=0&consumer=192.168.10.107&elapsed=77&failure=0&input=2400&interface=org.rembau.dubboTest.TestDubboService&max.concurrent=1&max.elapsed=38&max.input=200&max.output=0&method=sayHello&output=0&success=12&timestamp=1487949538795

    @Override
    public List<URL> lookup(URL url) {
        logger.info("接收到lookup信息：{}", url);
        return null;
    }
}

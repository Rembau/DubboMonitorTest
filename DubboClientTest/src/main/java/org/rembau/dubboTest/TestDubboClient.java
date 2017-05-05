package org.rembau.dubboTest;

import com.unilife.common.dto.push.DeviceFilterParam;
import com.unilife.common.dto.push.PushDataContext;
import com.unilife.common.dto.push.PushDataDto;
import com.unilife.common.service.push.DataPushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by rembau on 2017/2/24.
 */
@Service
public class TestDubboClient {
    private final static Logger logger = LoggerFactory.getLogger(TestDubboClient.class);

    @Autowired
    DataPushService dataPushService;

    @PostConstruct
    public void test() {
        logger.info("测试推送==================================");
        PushDataDto pushDataDto = new PushDataDto();
        pushDataDto.setImmediate(true);

        PushDataContext pushDataContext = new PushDataContext();
        pushDataContext.setDataType("000000");
        pushDataContext.setEffectiveTime(new Date());
        pushDataContext.setMessageType(1);
        pushDataContext.setData(
                "{\n" +
                        "  \"messageTitle\":\"优惠券到账提醒\",\n" +
                        "  \"messageContent\":\"balabala\"\n" +
                        "}");
        pushDataDto.setData(pushDataContext);

        DeviceFilterParam filterParam = new DeviceFilterParam();
        filterParam.setClientType(1);
        filterParam.setDeviceIdList(new HashSet<String>());
        filterParam.getDeviceIdList().add("7864e6176fed");
        pushDataDto.setFilterParam(filterParam);

        dataPushService.pushMessage(pushDataDto);
    }

    public static void main(String args[]) {

        new ClassPathXmlApplicationContext("classpath:*.xml");
        logger.info("client start success");

        while(true){
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                logger.error("", e);
            }
        }
    }
}

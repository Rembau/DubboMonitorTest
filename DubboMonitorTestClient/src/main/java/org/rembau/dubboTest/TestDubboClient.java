package org.rembau.dubboTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by rembau on 2017/2/24.
 */
@Service
public class TestDubboClient {
    private final static Logger logger = LoggerFactory.getLogger(TestDubboClient.class);

    @Autowired
    TestDubboService testDubboService;

    @Scheduled(cron = "0/10 * * * * ?")
    public void test() {
        String sayHello = testDubboService.sayHello();
        logger.info("返回结果：" + sayHello);
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

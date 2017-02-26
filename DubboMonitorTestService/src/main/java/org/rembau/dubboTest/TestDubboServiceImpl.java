package org.rembau.dubboTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by rembau on 2017/2/24.
 */
@Service
public class TestDubboServiceImpl implements TestDubboService {
    private final static Logger logger = LoggerFactory.getLogger(TestDubboService.class);

    public String sayHello() {
        logger.info("服务器打印：hello world!");
        return "hello world result";
    }

    public static void main(String args[]) {
        new ClassPathXmlApplicationContext("classpath:*.xml");

        while(true){
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                logger.error("", e);
            }
        }
    }
}

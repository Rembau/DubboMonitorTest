package org.rembau.dubboTest;

import javassist.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

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

        //        System.setProperty("dubbo.monitor.interval", "1000");
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass cc = pool.get("com.alibaba.dubbo.config.MonitorConfig");
            // 增加属性，这里仅仅是增加属性字段
            CtField ctField = new CtField(CtClass.intType, "interval", cc);
            ctField.setModifiers(Modifier.PUBLIC);
            cc.addField(ctField, "1000");

            CtMethod ctMethod = new CtMethod(CtClass.intType, "getInterval", null, cc);
            ctMethod.setBody("return interval;");
            ctMethod.setModifiers(Modifier.PUBLIC);
            cc.addMethod(ctMethod);
            cc.toClass();
        } catch (NotFoundException | CannotCompileException e) {
            logger.error("", e);
        }

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

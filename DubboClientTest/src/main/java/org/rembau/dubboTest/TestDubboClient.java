package org.rembau.dubboTest;

import com.unilife.common.dto.push.FilterParam;
import com.unilife.common.dto.push.PushDataContext;
import com.unilife.common.dto.push.PushDataDto;
import com.unilife.common.dto.push.PushMessageDto;
import com.unilife.common.service.push.DataPushService;
import com.unilife.media.dto.message.type.MessageGroupInfoDto;
import com.unilife.media.dto.message.type.MessageTypeInfoDto;
import com.unilife.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        //推送时间
        pushDataDto.setImmediate(false);
        pushDataDto.setAdvance(true);
        pushDataDto.setAdvanceTime(2 * 60 * 60 * 1000);

        PushDataContext pushDataContext = new PushDataContext();
        pushDataContext.setDataType(Constant.DataPush.DATA_TYPE_MESSAGE);
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-05-09 15:45:20");
            pushDataContext.setEffectiveTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        pushDataContext.setMessageType(Constant.DataPush.MESSAGE_TYPE_DATA_CHANGE);

        PushMessageDto pushMessageDto = new PushMessageDto();
        pushMessageDto.setMessageGroup(MessageGroupInfoDto.SYSTEM.getId());
        pushMessageDto.setMessageType(MessageTypeInfoDto.NEW_COUPON.getId());
        pushMessageDto.setMessageTitle(MessageTypeInfoDto.NEW_COUPON.getName());

        pushDataContext.setData(pushMessageDto);
        pushDataDto.setData(pushDataContext);

        FilterParam filterParam = new FilterParam();
        filterParam.setClientType(1);
        filterParam.setDeviceIdList(new HashSet<String>());
        filterParam.getDeviceIdList().add("testDeviceCode");

        /*filterParam.setCityList(new HashSet<String>());
        filterParam.getCityList().add("上海市");*/

        /*filterParam.setDeviceModelList(new HashSet<String>());
        filterParam.getDeviceModelList().add("kqd428lga");*/

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

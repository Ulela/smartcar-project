package com.smart.car.message.mq;

/**
 * Consumer消费者类
 * @author chenf
 * @version 1.0
 * @date 2022-07-25
 */
import com.smart.car.common.res.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.context.IntegrationContextUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.ErrorMessage;

@Slf4j
@Service
@Component
public class ConsumerReceive {

    //消费消息
    //监听类：仅做测试使用，正式应用可集成相应消息推送接口，比如极光、微信、阿里云短信等
    //@StreamListener(“你的消息接收的Channel名字”)
    @StreamListener(Sink.INPUT)
    public void receiveInput(String messageBody) throws BusinessException {
        log.info("通过stream收到消息，接收的信息= " +messageBody +" by RocketMQ...");
        // 此处抛出一个 RuntimeException 异常，模拟消费失败，进而重试。
        //throw new RuntimeException("测试全局异常拦截~");
    }

    /**
     * 全局异常处理
     * ErrorMessage对象，即错误消息。
     * @param errorMessage 异常消息对象
     * 注解内部直接填"errorChannel"也行
     */
    @StreamListener(IntegrationContextUtils.ERROR_CHANNEL_BEAN_NAME)
    public void error(ErrorMessage errorMessage){
        log.error("发生异常 => {}",errorMessage.getPayload());
    }
}

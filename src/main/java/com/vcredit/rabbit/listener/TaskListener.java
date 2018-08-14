package com.vcredit.rabbit.listener;

import com.rabbitmq.client.Channel;
import com.vcredit.rabbit.dto.EmailAllBill;
import com.vcredit.rabbit.dto.EmailTaskSubmit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @Author zhouliliang
 * @Description:
 * @Date: Created in 2018/5/28 18:22
 */
@Slf4j
@Service
@RabbitListener(queues = "retry")
public class TaskListener {
    @RabbitHandler
    public void process(@Payload EmailAllBill emailAllBill) throws Exception {
        System.out.println("EmailAllBill :" + emailAllBill);
    }

    @RabbitHandler
    public void process(@Payload EmailTaskSubmit emailTaskSubmit, @Header(AmqpHeaders.CHANNEL) Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        try {
            System.out.println("EmailTaskSubmit:" + emailTaskSubmit);
            channel.basicAck(tag, false);
        } catch (Exception e) {
            channel.basicNack(tag, false, true);
        }
    }
}

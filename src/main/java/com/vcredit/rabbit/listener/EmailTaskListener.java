package com.vcredit.rabbit.listener;

import com.rabbitmq.client.Channel;
import com.vcredit.rabbit.dto.email.EmailAllBill;
import com.vcredit.rabbit.dto.email.EmailTaskSubmit;
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
@RabbitListener(queues = "q_email")
public class EmailTaskListener {
    @RabbitHandler
    public void process(@Payload EmailAllBill emailAllBill, @Header(AmqpHeaders.CHANNEL) Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        try {
            log.info(emailAllBill.toString());
            channel.basicAck(tag, false);
        } catch (Exception e) {
            channel.basicNack(tag, false, true);
        }
    }

    @RabbitHandler
    public void process(@Payload EmailTaskSubmit emailTaskSubmit, @Header(AmqpHeaders.CHANNEL) Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        try {
            log.info(emailTaskSubmit.toString());
            channel.basicAck(tag, false);
        } catch (Exception e) {
            channel.basicNack(tag, false, true);
        }
    }
}

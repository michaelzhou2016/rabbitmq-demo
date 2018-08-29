package com.vcredit.rabbit.listener;

import com.rabbitmq.client.Channel;
import com.vcredit.rabbit.dto.bank.BankAllBill;
import com.vcredit.rabbit.dto.bank.BankTask;
import com.vcredit.rabbit.dto.bank.BankTaskFail;
import com.vcredit.rabbit.dto.bank.BankTaskSubmit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author zhouliliang
 * @Description:
 * @Date: Created in 2018/5/28 18:22
 */
@Service
@RabbitListener(queues = "q_bank")
@Slf4j
public class BankTaskListener {
    @RabbitHandler
    public void process(@Payload BankAllBill bankAllBill, @Header(AmqpHeaders.CHANNEL) Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        try {
            log.info(bankAllBill.toString());
            channel.basicAck(tag, false);
        } catch (Exception e) {
            log.error("BankAllBill exception:", e);
            channel.basicNack(tag, false, true);
        }
    }

    @RabbitHandler
    public void process(@Payload BankTaskSubmit bankTaskSubmit, @Header(AmqpHeaders.CHANNEL) Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        try {
            log.info(bankTaskSubmit.toString());
            channel.basicAck(tag, false);
        } catch (Exception e) {
            log.error("BankTaskSubmit exception:", e);
            channel.basicNack(tag, false, true);
        }
    }

    @RabbitHandler
    public void process(@Payload BankTask bankTask, @Header(AmqpHeaders.CHANNEL) Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        try {
            log.info(bankTask.toString());
            channel.basicAck(tag, false);
        } catch (Exception e) {
            log.error("BankTask exception:", e);
            channel.basicNack(tag, false, true);
        }
    }

    @RabbitHandler
    public void process(@Payload BankTaskFail bankTaskFail, @Header(AmqpHeaders.CHANNEL) Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        try {
            log.info(bankTaskFail.toString());
            channel.basicAck(tag, false);
        } catch (Exception e) {
            log.error("BankTaskFail exception:", e);
            channel.basicNack(tag, false, true);
        }
    }
}

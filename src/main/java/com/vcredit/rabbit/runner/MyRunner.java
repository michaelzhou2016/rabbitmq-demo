package com.vcredit.rabbit.runner;

import com.vcredit.rabbit.dto.bank.BankAllBill;
import com.vcredit.rabbit.dto.email.EmailAllBill;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author zhouliliang
 * @Description:
 * @Date: Created in 2018/5/29 9:38
 */
@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) throws Exception {
        Thread.sleep(1000);
        for (int i = 0; i < 100; i++) {
            EmailAllBill emailAllBill = new EmailAllBill();
            emailAllBill.setUserId("zhouliliang" + i);
            emailAllBill.setEmail("strength_zhou@126.com");
            rabbitTemplate.convertAndSend("ex_email", "test.email", emailAllBill);

            BankAllBill bankAllBill = new BankAllBill();
            bankAllBill.setUserId("yucunduo" + i);
            bankAllBill.setTaskId("123");
            rabbitTemplate.convertAndSend("ex_bank", "test.bank", bankAllBill);
        }
    }
}

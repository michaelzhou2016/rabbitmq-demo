package com.vcredit.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhouliliang
 * @Description:
 * @Date: Created in 2018/5/28 18:09
 */
@EnableRabbit
@Configuration
public class RabbitMQConfig {
    @Bean(name = "bankTestQueue")
    public Queue bankBillQueue() {
        return new Queue("q_bank", true);
    }

    @Bean(name = "bankTestExchange")
    public DirectExchange bankDirectExchange() {
        return new DirectExchange("ex_bank");
    }

    @Bean(name = "bankTestBinding")
    public Binding bankBinding(@Qualifier(value = "bankTestExchange") DirectExchange exchange, @Qualifier(value = "bankTestQueue") Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange).with("test.bank");
    }


    @Bean(name = "emailTestQueue")
    public Queue emailBillQueue() {
        return new Queue("q_email", true);
    }

    @Bean(name = "emailTestExchange")
    public DirectExchange emailDirectExchange() {
        return new DirectExchange("ex_email");
    }

    @Bean(name = "emailTestBinding")
    public Binding emailBinding(@Qualifier(value = "emailTestExchange") DirectExchange exchange, @Qualifier(value = "emailTestQueue") Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange).with("test.email");
    }
}

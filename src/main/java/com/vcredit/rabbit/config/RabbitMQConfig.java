package com.vcredit.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
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
    @Bean
    public Queue queue() {
        return  new Queue("retry", true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("retry.direct");
    }

    @Bean
    public Binding binding(DirectExchange exchange, Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange).with("retry.msg");
    }
}

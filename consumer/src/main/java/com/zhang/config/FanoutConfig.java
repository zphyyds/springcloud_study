package com.zhang.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zph
 * @version 1.0
 */
@Configuration
public class FanoutConfig {

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("itcast.exchange");
    }

    @Bean
    public Queue fanoutQueue1(){
        return new Queue("itcast.queue1");
    }

    @Bean
    public Binding binding1(FanoutExchange fanoutExchange,Queue fanoutQueue1){
       return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    public Queue fanoutQueue2(){
        return new Queue("itcast.queue2");
    }

    @Bean
    public Binding binding2(FanoutExchange fanoutExchange,Queue fanoutQueue2){
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }


    @Bean
    public Queue objectQueue(){
        return new Queue("object.queue");
    }
}

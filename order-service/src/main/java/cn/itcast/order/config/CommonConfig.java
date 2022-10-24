package cn.itcast.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zph
 * @version 1.0
 */

@Configuration
public class CommonConfig {


    /**
     * 创建RestTemplate对象并注入spring容器
     * @return
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

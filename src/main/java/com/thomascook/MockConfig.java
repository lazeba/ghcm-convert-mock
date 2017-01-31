package com.thomascook;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.github.tcdl.msb.api.MsbContext;
import io.github.tcdl.msb.api.MsbContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alexandr Zolotov
 */
@Configuration
public class MockConfig {

    @Bean
    public Config config(){
        return ConfigFactory.load();
    }

    @Bean
    public MsbContext msbContext(Config config){
        return new MsbContextBuilder().withConfig(config).build();
    }
}

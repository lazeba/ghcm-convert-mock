package com.thomascook;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Runner {
    public static final Config CONFIG = ConfigFactory.load();

    public static final SpringApplication APP =
            new SpringApplicationBuilder()
                    .bannerMode(Banner.Mode.OFF)
                    .sources(MockConfig.class)
                    .build();

    public static void main(String[] args) {
        APP.run(args);
    }
}

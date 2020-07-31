package com.unleashhosted.example.unleashdemo;

import no.finn.unleash.DefaultUnleash;
import no.finn.unleash.Unleash;
import no.finn.unleash.util.UnleashConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    Unleash unleash()  {
        UnleashConfig config = UnleashConfig.builder()
                .appName("coronga")
                .unleashAPI("http://unleash.herokuapp.com/api/")
                .synchronousFetchOnInitialisation(true)
                .build();

        return new DefaultUnleash(config);
    }
}

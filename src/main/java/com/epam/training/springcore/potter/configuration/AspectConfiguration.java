package com.epam.training.springcore.potter.configuration;

import com.epam.training.springcore.potter.aspect.BattleAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConfiguration {

    @Bean
    public BattleAspect battleAspect() {
        return new BattleAspect();
    }

}

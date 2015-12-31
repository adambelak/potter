package com.epam.training.springcore.potter.configuration;


import com.epam.training.springcore.potter.intern.domain.wand.DefaultWand;
import com.epam.training.springcore.potter.intern.domain.wand.NullWand;
import com.epam.training.springcore.potter.domain.Wand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class WandConfiguration {

    @Bean
    public Wand nullWand() {
        return new NullWand();
    }

    @Bean
    public Wand harrysWand() {
        return new DefaultWand(BigDecimal.valueOf(10), BigDecimal.valueOf(1.25));
    }

    @Bean
    public Wand ronsWand() {
        return new DefaultWand(BigDecimal.valueOf(2), BigDecimal.valueOf(0.75));
    }

    @Bean
    public Wand hermionesWand() {
        return new DefaultWand(BigDecimal.valueOf(5), BigDecimal.valueOf(1.1));
    }

    @Bean
    public Wand voldemortsWand() {
        return new DefaultWand(BigDecimal.valueOf(10), BigDecimal.valueOf(1));
    }

    @Bean
    public Wand malfoysWand() {
        return new DefaultWand(BigDecimal.valueOf(3), BigDecimal.valueOf(0.85));
    }

    @Bean
    public Wand bellatrixWand() {
        return new DefaultWand(BigDecimal.valueOf(3), BigDecimal.valueOf(1));
    }

}

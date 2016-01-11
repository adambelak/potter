package com.epam.training.springcore.potter.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({AspectConfiguration.class, BattleConfiguration.class, SpellConfiguration.class, WandConfiguration.class, WizardConfiguration.class})
public class ApplicationConfig {
}

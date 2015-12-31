package com.epam.training.springcore.potter.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@Import({BattleConfiguration.class, SpellConfiguration.class, WandConfiguration.class, WizardConfiguration.class})
@ComponentScan({"com.epam.training.springcore.potter.aspect"})
public class ApplicationConfig {
}

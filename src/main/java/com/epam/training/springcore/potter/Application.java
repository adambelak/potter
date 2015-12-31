package com.epam.training.springcore.potter;

import com.epam.training.springcore.potter.configuration.ApplicationConfig;
import com.epam.training.springcore.potter.domain.Battle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            Battle battle = context.getBean(Battle.class);
            battle.fight();
        }
    }
}

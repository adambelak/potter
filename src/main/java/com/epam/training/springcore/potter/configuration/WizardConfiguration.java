package com.epam.training.springcore.potter.configuration;


import com.epam.training.springcore.potter.intern.domain.wizard.BadWizard;
import com.epam.training.springcore.potter.intern.domain.wizard.GoodWizard;
import com.epam.training.springcore.potter.domain.Wand;
import com.epam.training.springcore.potter.domain.Wizard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class WizardConfiguration {

    @Resource(name = "harrysWand")
    private Wand harrysWand;
    @Resource(name = "ronsWand")
    private Wand ronsWand;
    @Resource(name = "hermionesWand")
    private Wand hermionesWand;
    @Resource(name = "voldemortsWand")
    private Wand voldemortsWand;
    @Resource(name = "bellatrixWand")
    private Wand bellatrixWand;
    @Resource(name = "malfoysWand")
    private Wand malfoysWand;

    @Bean
    public Wizard harry() {
        return new GoodWizard("Harry", BigDecimal.valueOf(120), BigDecimal.valueOf(120), harrysWand);
    }

    @Bean
    public Wizard ron() {
        return new GoodWizard("Ron", BigDecimal.valueOf(100), BigDecimal.valueOf(100), ronsWand);
    }

    @Bean
    public Wizard hermione() {
        return new GoodWizard("Hermione", BigDecimal.valueOf(120), BigDecimal.valueOf(105), hermionesWand);
    }

    @Bean
    public Wizard voldemort() {
        return new BadWizard("Voldemort", BigDecimal.valueOf(150), BigDecimal.valueOf(150), voldemortsWand);
    }

    @Bean
    public Wizard bellatrix() {
        return new BadWizard("Bellatrix", BigDecimal.valueOf(90), BigDecimal.valueOf(90), bellatrixWand);
    }

    @Bean
    public Wizard malfoy() {
        return new BadWizard("Malfoy", BigDecimal.valueOf(85), BigDecimal.valueOf(85), malfoysWand);
    }

    @Bean
    public List<Wizard> goodWizards() {
        return new ArrayList<>(Arrays.asList(harry(), hermione(), ron()));
    }

    @Bean
    public List<Wizard> badWizards() {
        return new ArrayList<>(Arrays.asList(voldemort(), bellatrix(), malfoy()));
    }


}

package com.epam.training.springcore.potter.configuration;

import com.epam.training.springcore.potter.intern.domain.DefaultBattle;
import com.epam.training.springcore.potter.domain.Battle;
import com.epam.training.springcore.potter.domain.Wizard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.List;

@Configuration
public class BattleConfiguration {

    @Resource(name = "goodWizards")
    private List<Wizard> goodWizards;
    @Resource(name = "badWizards")
    private List<Wizard> badWizards;

    @Bean
    public Battle battle() {
        return new DefaultBattle(goodWizards, badWizards);
    }

}

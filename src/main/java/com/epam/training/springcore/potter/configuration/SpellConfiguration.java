package com.epam.training.springcore.potter.configuration;

import com.epam.training.springcore.potter.intern.domain.spell.*;
import com.epam.training.springcore.potter.domain.Spell;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SpellConfiguration {

    @Bean
    public Spell cruciatusCurse() {
        return new CruciatusCurse(BigDecimal.valueOf(75), BigDecimal.valueOf(50));
    }

    @Bean
    public Spell disarmingCharm() {
        return new DisarmingCharm(BigDecimal.valueOf(20));
    }

    @Bean
    public Spell killingCurse() {
        return new KillingCurse(BigDecimal.valueOf(90));
    }

    @Bean
    public Spell salvioHexia() {
        return new SalvioHexia(BigDecimal.valueOf(25), BigDecimal.valueOf(25));
    }

    @Bean
    public Spell summoningCharm() {
        return new SummoningCharm(BigDecimal.valueOf(15));
    }

    @Bean
    public List<Spell> goodAttackSpells() {
        return new ArrayList<>(Arrays.asList(disarmingCharm(), summoningCharm()));
    }

    @Bean
    public List<Spell> defenseSpells() {
        return new ArrayList<>(Arrays.asList(salvioHexia()));
    }

    @Bean
    public List<Spell> badAttackSpells() {
        return new ArrayList<>(Arrays.asList(cruciatusCurse(), killingCurse()));
    }

}

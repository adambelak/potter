package com.epam.training.springcore.potter.intern.domain.spell;

import com.epam.training.springcore.potter.domain.Wizard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class SummoningCharm extends AbstractSpell {
    private static final Logger LOGGER = LoggerFactory.getLogger(CruciatusCurse.class);

    public SummoningCharm(BigDecimal cost) {
        super(cost);
    }

    @Override
    public void spell(Wizard wizard) {
        LOGGER.trace("accio, {}", wizard);
        wizard.disarm();
    }

}

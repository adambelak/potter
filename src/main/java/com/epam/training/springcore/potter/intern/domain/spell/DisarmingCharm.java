package com.epam.training.springcore.potter.intern.domain.spell;

import com.epam.training.springcore.potter.domain.Wizard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class DisarmingCharm extends AbstractSpell {
    private static final Logger LOGGER = LoggerFactory.getLogger(DisarmingCharm.class);

    public DisarmingCharm(BigDecimal cost) {
        super(cost);
    }

    @Override
    public void spell(Wizard wizard) {
        LOGGER.trace("expelliarmus, {}", wizard);
        wizard.disarm();
    }

}

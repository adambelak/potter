package com.epam.training.springcore.potter.intern.domain.spell;

import com.epam.training.springcore.potter.domain.Wizard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class KillingCurse extends AbstractSpell {
    private static final Logger LOGGER = LoggerFactory.getLogger(KillingCurse.class);

    public KillingCurse(BigDecimal cost) {
        super(cost);
    }

    @Override
    public void spell(Wizard wizard) {
        LOGGER.trace("avada kedavra, {}", wizard);
        wizard.die();
    }

}

package com.epam.training.springcore.potter.intern.domain.spell;

import com.epam.training.springcore.potter.domain.Wizard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class CruciatusCurse extends AbstractSpell {
    private static final Logger LOGGER = LoggerFactory.getLogger(CruciatusCurse.class);

    private final BigDecimal damage;

    public CruciatusCurse(BigDecimal cost, BigDecimal damage) {
        super(cost);
        this.damage = damage;
    }

    @Override
    public void spell(Wizard wizard) {
        LOGGER.trace("crucio, {}", wizard);
        wizard.damage(damage);
    }
}

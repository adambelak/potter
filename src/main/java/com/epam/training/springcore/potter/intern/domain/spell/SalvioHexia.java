package com.epam.training.springcore.potter.intern.domain.spell;

import com.epam.training.springcore.potter.domain.Wizard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class SalvioHexia extends AbstractSpell {
    private static final Logger LOGGER = LoggerFactory.getLogger(CruciatusCurse.class);

    private BigDecimal value;

    public SalvioHexia(BigDecimal cost, BigDecimal value) {
        super(cost);
        this.value = value;
    }

    @Override
    public void spell(Wizard wizard) {
        LOGGER.trace("salvio hexia, {}", wizard);
        wizard.givePower(value);
    }
}

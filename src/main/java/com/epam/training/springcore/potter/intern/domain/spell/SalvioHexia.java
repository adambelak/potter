package com.epam.training.springcore.potter.intern.domain.spell;

import com.epam.training.springcore.potter.domain.Wizard;

import java.math.BigDecimal;

public class SalvioHexia extends AbstractSpell {

    private BigDecimal value;

    public SalvioHexia(BigDecimal cost, BigDecimal value) {
        super(cost);
        this.value = value;
    }

    @Override
    public void spell(Wizard wizard) {
        wizard.givePower(value);
    }
}

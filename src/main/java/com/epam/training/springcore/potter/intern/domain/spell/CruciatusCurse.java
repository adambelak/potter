package com.epam.training.springcore.potter.intern.domain.spell;

import com.epam.training.springcore.potter.domain.Wizard;

import java.math.BigDecimal;

public class CruciatusCurse extends AbstractSpell {

    private final BigDecimal damage;

    public CruciatusCurse(BigDecimal cost, BigDecimal damage) {
        super(cost);
        this.damage = damage;
    }

    @Override
    public void spell(Wizard wizard) {
        wizard.damage(damage);
    }
}

package com.epam.training.springcore.potter.intern.domain.spell;

import com.epam.training.springcore.potter.domain.Wizard;

import java.math.BigDecimal;

public class KillingCurse extends AbstractSpell {

    public KillingCurse(BigDecimal cost) {
        super(cost);
    }

    @Override
    public void spell(Wizard wizard) {
        wizard.die();
    }

}

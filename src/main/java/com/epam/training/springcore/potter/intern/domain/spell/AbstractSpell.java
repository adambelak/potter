package com.epam.training.springcore.potter.intern.domain.spell;


import com.epam.training.springcore.potter.domain.Spell;

import java.math.BigDecimal;

public abstract class AbstractSpell implements Spell {

    private final BigDecimal cost;

    public AbstractSpell(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

}

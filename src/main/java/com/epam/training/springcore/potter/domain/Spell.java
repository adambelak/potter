package com.epam.training.springcore.potter.domain;

import java.math.BigDecimal;

public interface Spell {

    BigDecimal getCost();
    void spell(Wizard wizard);

}

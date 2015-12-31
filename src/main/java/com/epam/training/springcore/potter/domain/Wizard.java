package com.epam.training.springcore.potter.domain;

import java.math.BigDecimal;

public interface Wizard {

    BigDecimal getHealth();
    boolean canAttack();
    void attack(Wizard wizard);
    void disarm();
    void die();
    void damage(BigDecimal value);
    void givePower(BigDecimal value);

}

package com.epam.training.springcore.potter.intern.domain.wizard;

import com.epam.training.springcore.potter.intern.domain.wand.NullWand;
import com.epam.training.springcore.potter.domain.Spell;
import com.epam.training.springcore.potter.domain.Wand;
import com.epam.training.springcore.potter.domain.Wizard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public abstract class AbstractWizard implements Wizard {
    private static final Logger LOGGER = LoggerFactory.getLogger(Wizard.class);

    private final String name;
    private BigDecimal mana;
    private BigDecimal health;
    private Wand wand;

    public AbstractWizard(String name, BigDecimal mana, BigDecimal health, Wand wand) {
        this.name = name;
        this.mana = mana;
        this.health = health;
        this.wand = wand;
    }

    public BigDecimal getMana() {
        return mana;
    }

    public void setMana(BigDecimal mana) {
        this.mana = mana;
    }

    public BigDecimal getHealth() {
        return health;
    }

    public void setHealth(BigDecimal health) {
        this.health = health;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    @Override
    public boolean canAttack() {
        return !wand.equals(new NullWand()) && getMana().compareTo(BigDecimal.TEN) > 0 && getHealth().compareTo(BigDecimal.ZERO) > 0;
    }

    @Override
    public void disarm() {
        if (getMana().compareTo(BigDecimal.valueOf(50)) < 0) {
            LOGGER.trace("{} disarmed", this);
            setWand(new NullWand());
        } else {
            LOGGER.trace("{} has shield", this);
            decrementMana(BigDecimal.TEN);
        }
    }

    @Override
    public void die() {
        LOGGER.trace("{} died in battle", this);
        setWand(new NullWand());
        setMana(BigDecimal.ZERO);
        setHealth(BigDecimal.ZERO);
    }

    @Override
    public void damage(BigDecimal value) {
        LOGGER.trace("{} injured and lost {} health point", this, value);
        decrementHealth(value);
        if (!hasHealth()) {
            die();
        }
    }

    protected void decrementMana(BigDecimal value) {
        if (!wand.equals(new NullWand()) && !wand.getLuck().equals(BigDecimal.ZERO)) {
            mana = mana.subtract(value.subtract(wand.getPower()).divide(wand.getLuck(), BigDecimal.ROUND_CEILING));
        } else {
            mana = mana.subtract(value);
        }
    }

    private void decrementHealth(BigDecimal value) {
        health = health.subtract(value);
    }

    private boolean hasHealth() {
        return health.longValue() > 0;
    }

    protected boolean hasEnoughMana(Spell spell) {
        return getMana().compareTo(spell.getCost()) >= 0;
    }

    @Override
    public String toString() {
        return name + " (mana=" + mana + ", health=" + health + '}';
    }
}

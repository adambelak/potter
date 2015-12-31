package com.epam.training.springcore.potter.intern.domain.wand;

import com.epam.training.springcore.potter.domain.Wand;

import java.math.BigDecimal;

public class DefaultWand implements Wand {

    private final BigDecimal power;
    private final BigDecimal luck;

    public DefaultWand(BigDecimal power, BigDecimal luck) {
        this.power = power;
        this.luck = luck;
    }

    @Override
    public BigDecimal getPower() {
        return power;
    }

    @Override
    public BigDecimal getLuck() {
        return luck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefaultWand that = (DefaultWand) o;

        if (!power.equals(that.power)) return false;
        return luck.equals(that.luck);

    }

    @Override
    public int hashCode() {
        int result = power.hashCode();
        result = 31 * result + luck.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DefaultWand{" +
                "power=" + power +
                ", luck=" + luck +
                '}';
    }
}

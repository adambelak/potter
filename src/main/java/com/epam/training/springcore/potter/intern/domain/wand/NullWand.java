package com.epam.training.springcore.potter.intern.domain.wand;

import com.epam.training.springcore.potter.domain.Wand;

import java.math.BigDecimal;

public class NullWand implements Wand {

    @Override
    public BigDecimal getPower() {
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getLuck() {
        return BigDecimal.valueOf(10000);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public boolean equals(Object object) {
        if (object == null) return false;
        if (object == this) return true;
        return  object instanceof NullWand;
    }

}

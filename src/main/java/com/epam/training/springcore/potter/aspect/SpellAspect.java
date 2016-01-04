package com.epam.training.springcore.potter.aspect;

import com.epam.training.springcore.potter.domain.Wizard;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class SpellAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpellAspect.class);
    private static final String ACCIO = "accio, {}";
    private static final String AVADA_KEDAVRA = "avada kedavra, {}";
    private static final String CRUCIO = "crucio, {}";
    private static final String EXPELLIARMUS = "expelliarmus, {}";
    private static final String SALVIO_HEXIA = "salvio hexia, {}";

    @Before("execution(void com.epam.training.springcore.potter.intern.domain.spell.CruciatusCurse.spell(..)) && args(wizard)")
    public void beforeCruciatusSpell(Wizard wizard) {
        LOGGER.trace(CRUCIO, wizard);
    }

    @Before("execution(void com.epam.training.springcore.potter.intern.domain.spell.DisarmingCharm.spell(..)) && args(wizard)")
    public void beforeDisarmingCharm(Wizard wizard) {
        LOGGER.trace(EXPELLIARMUS, wizard);
    }

    @Before("execution(void com.epam.training.springcore.potter.intern.domain.spell.KillingCurse.spell(..)) && args(wizard)")
    public void beforeKillingCurse(Wizard wizard) {
        LOGGER.trace(AVADA_KEDAVRA, wizard);
    }

    @Before("execution(void com.epam.training.springcore.potter.intern.domain.spell.SalvioHexia.spell(..)) && args(wizard)")
    public void beforeSalvioHexia(Wizard wizard) {
        LOGGER.trace(SALVIO_HEXIA, wizard);
    }

    @Before("execution(void com.epam.training.springcore.potter.intern.domain.spell.SummoningCharm.spell(..)) && args(wizard)")
    public void beforeSummoningCharm(Wizard wizard) {
        LOGGER.trace(ACCIO, wizard);
    }

}

package com.epam.training.springcore.potter.aspect;

import com.epam.training.springcore.potter.domain.Wizard;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Aspect
public class SpellAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpellAspect.class);
    private static final String ACCIO = "accio, {}";
    private static final String AVADA_KEDAVRA = "avada kedavra, {}";
    private static final String CRUCIO = "crucio, {}";
    private static final String EXPELLIARMUS = "expelliarmus, {}";
    private static final String SALVIO_HEXIA = "salvio hexia, {}";


    @Before("execution(void com.epam.training.springcore.potter.intern.domain.spell.CruciatusCurse.spell(..))")
    public void beforeCruciatusSpell(JoinPoint joinPoint) {
        logSpell(joinPoint, CRUCIO);
    }

    @Before("execution(void com.epam.training.springcore.potter.intern.domain.spell.DisarmingCharm.spell(..))")
    public void beforeDisarmingCharm(JoinPoint joinPoint) {
        logSpell(joinPoint, EXPELLIARMUS);
    }

    @Before("execution(void com.epam.training.springcore.potter.intern.domain.spell.KillingCurse.spell(..))")
    public void beforeKillingCurse(JoinPoint joinPoint) {
        logSpell(joinPoint, AVADA_KEDAVRA);
    }

    @Before("execution(void com.epam.training.springcore.potter.intern.domain.spell.SalvioHexia.spell(..))")
    public void beforeSalvioHexia(JoinPoint joinPoint) {
        logSpell(joinPoint, SALVIO_HEXIA);
    }

    @Before("execution(void com.epam.training.springcore.potter.intern.domain.spell.SummoningCharm.spell(..))")
    public void beforeSummoningCharm(JoinPoint joinPoint) {
        logSpell(joinPoint, ACCIO);
    }

    private void logSpell(JoinPoint joinPoint, String template) {
        Optional<Wizard> wizard = getWizard(joinPoint);
        if (wizard.isPresent()) {
            LOGGER.trace(template, wizard.get());
        }
    }

    private Optional<Wizard> getWizard(JoinPoint joinPoint) {
        Optional<Wizard> result = Optional.empty();
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            result = Optional.of((Wizard) args[0]);
        }
        return result;
    }

}

package com.epam.training.springcore.potter.aspect;

import com.epam.training.springcore.potter.domain.Battle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class BattleAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(BattleAspect.class);

    @Before("execution(void fight())")
    public void beforeFight() {
        LOGGER.debug("Let's begin the fight!");
    }

    @After("execution(void fight())")
    public void afterFight(JoinPoint joinPoint) {
        Battle battle = (Battle) joinPoint.getTarget();
        LOGGER.info("{} wizards won the battle!", battle.hasBadWizard() ? "Bad" : "Good");
        LOGGER.info("Good wizards: {}", battle.getGoodWizards());
        LOGGER.info("Bad wizards: {}", battle.getBadWizards());
    }

}

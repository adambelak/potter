package com.epam.training.springcore.potter.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class WizardAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(WizardAspect.class);

    @After("execution(void die())")
    public void afterDie() {
        LOGGER.trace("died in battle!");
    }


}

package com.epam.training.springcore.potter.intern.domain;

import com.epam.training.springcore.potter.domain.Battle;
import com.epam.training.springcore.potter.domain.Wizard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DefaultBattle implements Battle {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultBattle.class);

    private List<Wizard> goodWizards;
    private List<Wizard> badWizards;

    public DefaultBattle(List<Wizard> goodWizards, List<Wizard> badWizards) {
        this.goodWizards = goodWizards;
        this.badWizards = badWizards;
    }

    @Override
    public void fight() {
        while (hasGoodWizard() && hasBadWizzard()) {
            badWizardAttack();
            goodWizardAttack();
        }
        LOGGER.info("{} wizards win!", hasBadWizzard() ? "Bad" : "Good");
        LOGGER.info("Good wizards: {}", goodWizards);
        LOGGER.info("Bad wizards: {}", badWizards);
    }

    private void goodWizardAttack() {
        Optional<Wizard> wizard = goodWizards.stream().filter(w -> w.canAttack()).findAny();
        if (wizard.isPresent()) {
            Optional<Wizard> friend = goodWizards.stream().filter(w -> w.getHealth().compareTo(BigDecimal.TEN) < 1).findAny();
            if (friend.isPresent()) {
                LOGGER.info("{} protects {}", wizard.get(), friend.get());
                wizard.get().attack(friend.get());
            } else {
                Optional<Wizard> enemy = badWizards.stream().filter(w -> w.canAttack()).findAny();
                if (enemy.isPresent()) {
                    LOGGER.info("{} attacks {}", wizard.get(), enemy.get());
                    wizard.get().attack(enemy.get());
                }
            }
        }
    }

    private void badWizardAttack() {
        Optional<Wizard> wizard = badWizards.stream().filter(w -> w.canAttack()).findAny();
        if (wizard.isPresent()) {
            Optional<Wizard> enemy = goodWizards.stream().filter(w -> w.canAttack()).findAny();
            if (enemy.isPresent()) {
                LOGGER.info("{} attacks {}", wizard.get(), enemy.get());
                wizard.get().attack(enemy.get());
            }
        }
    }

    private boolean hasBadWizzard() {
        Collections.shuffle(badWizards);
        return badWizards.stream().filter(w -> w.canAttack()).findAny().isPresent();
    }

    private boolean hasGoodWizard() {
        Collections.shuffle(goodWizards);
        return goodWizards.stream().filter(w -> w.canAttack()).findAny().isPresent();
    }


}

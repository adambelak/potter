package com.epam.training.springcore.potter.intern.domain.wizard;

import com.epam.training.springcore.potter.domain.Spell;
import com.epam.training.springcore.potter.domain.Wand;
import com.epam.training.springcore.potter.domain.Wizard;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class BadWizard extends AbstractWizard {

    @Resource(name = "badAttackSpells")
    private List<Spell> badAttackSpells;

    public BadWizard(String name, BigDecimal mana, BigDecimal health, Wand wand) {
        super(name, mana, health, wand);
    }

    @Override
    public void attack(Wizard wizard) {
        Optional<Spell> spell = badAttackSpells.stream().filter(s -> getMana().compareTo(s.getCost()) >= 0).findAny();
        if (spell.isPresent()) {
            spell.get().spell(wizard);
            decrementMana(spell.get().getCost());
        }
    }

    @Override
    public void givePower(BigDecimal value) {
        setMana(getMana().add(value));
    }
}

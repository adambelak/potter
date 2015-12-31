package com.epam.training.springcore.potter.intern.domain.wizard;

import com.epam.training.springcore.potter.domain.Spell;
import com.epam.training.springcore.potter.domain.Wand;
import com.epam.training.springcore.potter.domain.Wizard;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class GoodWizard extends AbstractWizard {

    @Resource(name = "defenseSpells")
    private List<Spell> defenseSpells;
    @Resource(name = "goodAttackSpells")
    private List<Spell> goodAttackSpells;

    public GoodWizard(String name, BigDecimal mana, BigDecimal health, Wand wand) {
        super(name, mana, health, wand);
    }

    @Override
    public void attack(Wizard wizard) {
        Optional<Spell> spell = (wizard instanceof GoodWizard)
                ? defenseSpells.stream().findAny()
                : goodAttackSpells.stream().findAny();
        if (spell.isPresent() && hasEnoughMana(spell.get())) {
            spell.get().spell(wizard);
            decrementMana(spell.get().getCost());
        }
    }

    @Override
    public void givePower(BigDecimal value) {
        setHealth(getHealth().add(value));
    }
}

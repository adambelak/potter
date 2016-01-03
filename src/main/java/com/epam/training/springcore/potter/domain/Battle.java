package com.epam.training.springcore.potter.domain;

import java.util.List;

public interface Battle {

    void fight();
    boolean hasGoodWizard();
    boolean hasBadWizard();
    List<Wizard> getGoodWizards();
    List<Wizard> getBadWizards();

}

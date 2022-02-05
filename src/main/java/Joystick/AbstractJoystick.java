package Joystick;

import Equipment.Equipment;
import MixingUnit.MixingUnit;

public abstract class AbstractJoystick {
    Equipment launcher;
    MixingUnit mixingUnit;

    public AbstractJoystick(Equipment Launcher, MixingUnit MixingUnit) {
        launcher = Launcher;
        mixingUnit = MixingUnit;
    }

    abstract public void pressLeftButton();
    abstract public void pressRightButton();
    abstract public void pressBackButton();
}

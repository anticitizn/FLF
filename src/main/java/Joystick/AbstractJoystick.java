package Joystick;

import Equipment.Equipment;
import MixingUnit.MixingUnit;

public abstract class AbstractJoystick {
    final Equipment launcher;
    final MixingUnit mixingUnit;

    public AbstractJoystick(Equipment Launcher, MixingUnit MixingUnit) {
        launcher = Launcher;
        mixingUnit = MixingUnit;
    }

    abstract public void pressLeftButton();
    abstract public void pressRightButton();
    abstract public void pressBackButton();
}

package Joystick;

import Equipment.Equipment;
import MixingUnit.MixingUnit;

public abstract class SmartJoystickState {
    Equipment launcher;
    MixingUnit mixingUnit;

    public SmartJoystickState(Equipment Launcher, MixingUnit MixingUnit) {
        launcher = Launcher;
        mixingUnit = MixingUnit;
    }

    public abstract void pressBackButton();
}

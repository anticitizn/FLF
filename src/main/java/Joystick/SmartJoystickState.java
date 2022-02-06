package Joystick;

import Equipment.Equipment;
import MixingUnit.MixingUnit;

public abstract class SmartJoystickState {
    final Equipment launcher;
    final MixingUnit mixingUnit;

    public SmartJoystickState(Equipment Launcher, MixingUnit MixingUnit) {
        launcher = Launcher;
        mixingUnit = MixingUnit;
    }

    public abstract void pressBackButton();
}

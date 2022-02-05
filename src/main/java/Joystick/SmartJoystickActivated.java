package Joystick;

import Equipment.Equipment;
import MixingUnit.MixingUnit;

public class SmartJoystickActivated extends SmartJoystickState{

    public SmartJoystickActivated(Equipment Launcher, MixingUnit MixingUnit) {
        super(Launcher, MixingUnit);
    }

    @Override
    public void pressBackButton() {
        launcher.shoot();
    }
}

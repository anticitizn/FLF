package Joystick;

import Equipment.Equipment;
import MixingUnit.MixingUnit;

public class SmartJoystickActivated extends SmartJoystickState{

    public SmartJoystickActivated(Equipment Launcher) {
        super(Launcher);
    }

    @Override
    public void pressBackButton() {
        launcher.shoot();
    }
}

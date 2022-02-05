package Joystick;

import Equipment.Equipment;
import MixingUnit.MixingUnit;

public class SmartJoystickDeactivated extends SmartJoystickState{

    public SmartJoystickDeactivated(Equipment Launcher, MixingUnit MixingUnit) {
        super(Launcher, MixingUnit);
    }

    @Override
    public void pressBackButton() {
        mixingUnit.switchRatio(launcher.getEquipmentType());
    }
}

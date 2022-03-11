package Joystick;

import Equipment.Equipment;
import MixingUnit.MixingUnit;

public class SmartJoystickDeactivated extends SmartJoystickState{

    public SmartJoystickDeactivated(Equipment Launcher) {
        super(Launcher);
    }

    @Override
    public void pressBackButton() {
        mixingUnitComponent.switchRatio(launcher.getEquipmentType());
    }
}

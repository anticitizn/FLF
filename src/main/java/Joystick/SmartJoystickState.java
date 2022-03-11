package Joystick;

import Equipment.Equipment;
import MixingUnit.MixingUnit;
import Task_01_Component.MixingUnitComponent;

public abstract class SmartJoystickState {
    final Equipment launcher;
    protected MixingUnitComponent mixingUnitComponent;

    public SmartJoystickState(Equipment Launcher) {
        launcher = Launcher;
    }

    public void setMixingUnitComponent(MixingUnitComponent mixingUnitComponent) {
        this.mixingUnitComponent = mixingUnitComponent;
    }

    public abstract void pressBackButton();
}

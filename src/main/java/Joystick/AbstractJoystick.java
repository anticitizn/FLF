package Joystick;

import Equipment.Equipment;
import MixingUnit.MixingUnit;
import Task_01_Component.MixingUnitComponent;

public abstract class AbstractJoystick {
    final Equipment launcher;
    protected MixingUnitComponent mixingUnitComponent;

    public AbstractJoystick(Equipment Launcher) {
        launcher = Launcher;
    }

    public void setMixingUnitComponent(MixingUnitComponent mixingUnitComponent) {
        this.mixingUnitComponent = mixingUnitComponent;
    }

    abstract public void pressLeftButton();
    abstract public void pressRightButton();
    abstract public void pressBackButton();
}

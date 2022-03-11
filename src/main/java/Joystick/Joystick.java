package Joystick;

import Equipment.Equipment;
import MixingUnit.MixingUnit;

public class Joystick extends AbstractJoystick{

    public Joystick(Equipment Launcher) {
        super(Launcher);
    }

    public void pressLeftButton() {
        if (launcher.isActive()) {
            launcher.deactivate();
        }
        else {
            launcher.activate();
        }
    }

    @Override
    public void pressRightButton() {
        if (launcher.isActive()) {
            mixingUnitComponent.switchRatio(launcher.getEquipmentType());
        }
    }

    @Override
    public void pressBackButton() {
        if (launcher.isActive()) {
            launcher.shoot();
        }
    }
}

package Joystick;

import Equipment.Equipment;
import MixingUnit.MixingUnit;

public class Joystick extends AbstractJoystick{

    public Joystick(Equipment Launcher, MixingUnit MixingUnit) {
        super(Launcher, MixingUnit);
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
            mixingUnit.switchRatio(launcher.getEquipmentType());
        }
    }

    @Override
    public void pressBackButton() {
        if (launcher.isActive()) {
            launcher.shoot();
        }
    }
}

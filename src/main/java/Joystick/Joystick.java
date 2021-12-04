package Joystick;

import Equipment.Equipment;
import MixingUnit.MixingUnit;

public class Joystick implements IJoystick{
    int ratioState = 0;
    Equipment launcher;
    MixingUnit mixingUnit;

    public Joystick(Equipment Launcher, MixingUnit MixingUnit) {
        launcher = Launcher;
        mixingUnit = MixingUnit;
    }

    @Override
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
        if (!launcher.isActive()) {
            return;
        } else {
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

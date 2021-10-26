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
        }

        switch (ratioState) {
            case 0 -> {
                mixingUnit.setRatio(3, launcher.getEquipmentType());
                ratioState = 1;
            }
            case 1 -> {
                mixingUnit.setRatio(5, launcher.getEquipmentType());
                ratioState = 2;
            }
            case 2 -> {
                mixingUnit.setRatio(10, launcher.getEquipmentType());
                ratioState = 3;
            }
            case 3 -> {
                mixingUnit.setRatio(0, launcher.getEquipmentType());
                ratioState = 0;
            }
        }
    }

    @Override
    public void pressBackButton() {
        if (launcher.isActive()) {
            launcher.shoot();
        }
    }
}

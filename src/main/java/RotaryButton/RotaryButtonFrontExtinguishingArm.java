package RotaryButton;

import Equipment.Equipment;

public class RotaryButtonFrontExtinguishingArm extends RotaryButton {

    public RotaryButtonFrontExtinguishingArm(Equipment Equipment) {
        super(Equipment);
    }

    @Override
    public void setState(int State) {
        switch (State) {
            case 1 -> {
                equipment.setOutputRate(500);
                state = 1;
            }
            case 2 -> {
                equipment.setOutputRate(1000);
                state = 2;
            }
            case 3 -> {
                equipment.setOutputRate(2500);
                state = 3;
            }
        }
    }
}

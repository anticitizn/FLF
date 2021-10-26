package RotaryButton;

import Equipment.Equipment;

public class RotaryButtonFrontLauncher extends RotaryButton{

    public RotaryButtonFrontLauncher(Equipment Equipment) {
        super(Equipment);
    }

    @Override
    public void setState(int State) {
        switch(State) {
            case 1 -> {
                equipment.setOutputRate(500);
                state = 1;
            }
            case 2 -> {
                equipment.setOutputRate(1000);
                state = 2;
            }
            case 3 -> {
                equipment.setOutputRate(1500);
                state = 3;
            }
            case 4 -> {
                equipment.setOutputRate(2000);
                state = 4;
            }
            case 5 -> {
                equipment.setOutputRate(2500);
                state = 5;
            }
            case 6 -> {
                equipment.setOutputRate(3000);
                state = 6;
            }
            case 7 -> {
                equipment.setOutputRate(3500);
                state = 7;
            }
        }
    }

}

package RotaryButton;

import Equipment.Equipment;

public abstract class RotaryButton {
    protected int state = 0;
    protected Equipment equipment;

    public RotaryButton(Equipment Equipment) {
        equipment = Equipment;
    }

    public void setState(int State) {
        state = State;
    }

    public int getState() {
        return state;
    }
}

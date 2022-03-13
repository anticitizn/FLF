package ControlPanel;

import CentralUnit.CentralUnit;
import Task_07_Command.Command;

public class Switch {
    private final Command onCommand;
    private final Command offCommand;
    private State state;

    public Switch(Command onCommand, Command offCommand) {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
        state = new StateOff(offCommand);
    }

    public void on() {
        state = new StateOn(onCommand);
    }

    public void off() {
        state = new StateOff(offCommand);
    }

    public void toggle() {
        if (state instanceof StateOff)
        {
            on();
        }
        else {
            off();
        }
    }

    public State getState() {
        return state;
    }
}

package ControlPanel;

import Task_07_Command.Command;

public abstract class State
{
    public State(Command command) {
        command.execute();
    }
}

package Task_07_Command;

import CentralUnit.CentralUnit;

public abstract class Command {
    protected CentralUnit centralUnit;

    public Command(CentralUnit centralUnit) {
        this.centralUnit = centralUnit;
    }

    public abstract void execute();
}

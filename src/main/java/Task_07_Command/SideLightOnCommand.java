package Task_07_Command;

import CentralUnit.CentralUnit;

public class SideLightOnCommand extends Command {
    public SideLightOnCommand(CentralUnit centralUnit) {
        super(centralUnit);
    }

    @Override
    public void execute() {
        centralUnit.switchOnSideLights();
    }
}

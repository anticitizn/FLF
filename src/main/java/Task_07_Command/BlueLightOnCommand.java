package Task_07_Command;

import CentralUnit.CentralUnit;

public class BlueLightOnCommand extends Command {
    public BlueLightOnCommand(CentralUnit centralUnit) {
        super(centralUnit);
    }

    @Override
    public void execute() {
        centralUnit.switchOnBlueLights();
    }
}

package Task_07_Command;

import CentralUnit.CentralUnit;

public class WarningLightOnCommand extends Command {
    public WarningLightOnCommand(CentralUnit centralUnit) {
        super(centralUnit);
    }

    @Override
    public void execute() {
        centralUnit.switchOnWarningLights();
    }
}

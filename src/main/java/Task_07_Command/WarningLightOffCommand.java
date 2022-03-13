package Task_07_Command;

import CentralUnit.CentralUnit;

public class WarningLightOffCommand extends Command {
    public WarningLightOffCommand(CentralUnit centralUnit) {
        super(centralUnit);
    }

    @Override
    public void execute() {
        centralUnit.switchOffWarningLights();
    }
}

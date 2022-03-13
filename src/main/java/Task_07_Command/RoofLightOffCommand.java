package Task_07_Command;

import CentralUnit.CentralUnit;

public class RoofLightOffCommand extends Command {
    public RoofLightOffCommand(CentralUnit centralUnit) {
        super(centralUnit);
    }

    @Override
    public void execute() {
        centralUnit.switchOffRoofLights();
    }
}

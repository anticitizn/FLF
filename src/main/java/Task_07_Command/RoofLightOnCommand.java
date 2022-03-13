package Task_07_Command;

import CentralUnit.CentralUnit;

public class RoofLightOnCommand extends Command {
    public RoofLightOnCommand(CentralUnit centralUnit) {
        super(centralUnit);
    }

    @Override
    public void execute() {
        centralUnit.switchOnRoofLights();
    }
}

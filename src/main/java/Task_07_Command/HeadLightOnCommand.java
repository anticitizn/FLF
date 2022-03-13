package Task_07_Command;

import CentralUnit.CentralUnit;

public class HeadLightOnCommand extends Command {
    public HeadLightOnCommand(CentralUnit centralUnit) {
        super(centralUnit);
    }

    @Override
    public void execute() {
        centralUnit.switchOnHeadLights();
    }
}

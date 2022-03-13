package Task_07_Command;

import CentralUnit.CentralUnit;

public class HeadLightOffCommand extends Command {
    public HeadLightOffCommand(CentralUnit centralUnit) {
        super(centralUnit);
    }

    @Override
    public void execute() {
        centralUnit.switchOffHeadLights();
    }
}

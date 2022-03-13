package Task_07_Command;

import CentralUnit.CentralUnit;

public class SideLightOffCommand extends Command {
    public SideLightOffCommand(CentralUnit centralUnit) {
        super(centralUnit);
    }

    @Override
    public void execute() {
        centralUnit.switchOffSideLights();
    }
}

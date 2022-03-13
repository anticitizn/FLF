package Task_07_Command;

import CentralUnit.CentralUnit;

public class BlueLightOffCommand extends Command {
    public BlueLightOffCommand(CentralUnit centralUnit) {
        super(centralUnit);
    }

    @Override
    public void execute() {
        centralUnit.switchOffBlueLights();
    }
}

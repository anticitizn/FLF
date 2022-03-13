package CentralUnit;

public class StateOff implements State {
    public StateOff(SwitchType switchType, CentralUnit centralUnit) {
        switch (switchType) {
            case BlueLight:
                centralUnit.switchOffBlueLights();
            case HeadLight:
                centralUnit.switchOffHeadLights();
            case RoofLight:
                centralUnit.switchOffRoofLights();
            case SideLight:
                centralUnit.switchOffSideLights();
            case WarningLight:
                centralUnit.switchOffWarningLights();
        }
    }

}

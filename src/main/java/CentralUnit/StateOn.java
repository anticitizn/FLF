package CentralUnit;

public class StateOn implements State {

    public StateOn(SwitchType switchType, CentralUnit centralUnit) {
        switch (switchType) {
            case BlueLight:
                centralUnit.switchOnBlueLights();
            case HeadLight:
                centralUnit.switchOnHeadLights();
            case RoofLight:
                centralUnit.switchOnRoofLights();
            case SideLight:
                centralUnit.switchOnSideLights();
            case WarningLight:
                centralUnit.switchOnWarningLights();
        }
    }
}

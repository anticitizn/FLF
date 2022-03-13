package CentralUnit;

import ControlPanel.ControlPanel;

public class Switch {
    private final SwitchType switchType;
    private final CentralUnit centralUnit;
    private State state;

    public Switch(SwitchType switchType, CentralUnit centralUnit) {
        this.switchType = switchType;
        this.centralUnit = centralUnit;
        state = new StateOff(switchType, centralUnit);
    }

    public void on() {
        state = new StateOn(switchType, centralUnit);
    }

    public void off() {
        state = new StateOff(switchType, centralUnit);
    }

    public void toggle() {
        if (state instanceof StateOff)
        {
            on();
        }
        else {
            off();
        }
    }
}

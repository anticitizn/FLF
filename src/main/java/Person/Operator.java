package Person;

import ControlPanel.ControlPanel;
import Joystick.AbstractJoystick;

public class Operator extends Person {
    private  ControlPanel controlPanel;

    public Operator(int id, final String firstName, final String lastName, final String dateOfBirthString, AbstractJoystick joystick){
        super(id,firstName, lastName, dateOfBirthString, joystick);
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }
}

package Person;

import ControlPanel.ControlPanel;
import ID.IDCard;

public class Operator extends Person{

    private  ControlPanel controlPanel;


    public Operator(int id, final String firstName, final String lastName, final String dateOfBirthString ){
        super(id,firstName, lastName, dateOfBirthString );


    }



    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }
}

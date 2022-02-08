package Person;

import Joystick.AbstractJoystick;
import Pedal.BrakePedal;
import Pedal.GasPedal;
import Steering.SteeringWheel;

public class Driver extends Person{
    private SteeringWheel steeringWheel;
    private GasPedal gasPedal;
    private BrakePedal brakePedal;

    public Driver(int id, final String firstName, final String lastName, final String dateOfBirthString, AbstractJoystick joystick){
        super(id,firstName, lastName, dateOfBirthString, joystick);

    }

    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(SteeringWheel steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    public GasPedal getGasPedal() {
        return gasPedal;
    }

    public void setGasPedal(GasPedal gasPedal) {
        this.gasPedal = gasPedal;
    }

    public BrakePedal getBrakePedal() {
        return brakePedal;
    }

    public void setBreakPedal(BrakePedal brakePedal) {
        this.brakePedal = brakePedal;
    }
}

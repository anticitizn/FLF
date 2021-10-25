package Person;

import Pedal.BreakPedal;
import Pedal.GasPedal;
import Steering.SteeringWheel;

public class Driver extends Person{

    private SteeringWheel steeringWheel;
    private GasPedal gasPedal;
    private BreakPedal breakPedal;


    public Driver(int id, final String firstName, final String lastName, final String dateOfBirthString){
        super(id,firstName, lastName, dateOfBirthString);
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

    public BreakPedal getBreakPedal() {
        return breakPedal;
    }

    public void setBreakPedal(BreakPedal breakPedal) {
        this.breakPedal = breakPedal;
    }
}

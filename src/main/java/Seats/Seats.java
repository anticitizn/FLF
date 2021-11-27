package Seats;

import Person.Driver;
import Person.Operator;
import Position.Position;

public class Seats {

    private Position position;
    private Driver driver;
    private Operator operator;
    private BreathingEquipment breathingEquipment;

    public Seats(Position position)
    {
        this.position=position;
    }

    public Position getPosition() {
        return position;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public BreathingEquipment getBreathingEquipment() {
        return breathingEquipment;
    }
}

package Engine;

import java.util.ArrayList;

public class Engine {

    private ArrayList<ElectricMotor> electricMotorsList;
    private BatteryManagement batteryManagement = new BatteryManagement();
    private int speed = 0;

    public Engine()
    {
        electricMotorsList=new ArrayList<ElectricMotor>();

        electricMotorsList.add(new ElectricMotor());
        electricMotorsList.add(new ElectricMotor());
    }

    public ArrayList<ElectricMotor> getElectricMotorsList() {
        return electricMotorsList;
    }

    public BatteryManagement getBatteryManagement() {
        return batteryManagement;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int speedEnergyRatio(int speed)
    {
       int speedEnergyRatio = speed*25;
       return speedEnergyRatio;
    }
}

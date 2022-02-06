package Engine;

import java.util.ArrayList;

public class Engine {

    private ArrayList<ElectricMotor> electricMotorsList;
    private BatteryManagement batteryManagement = new BatteryManagement();
    private int speed = 0;
    private boolean isOn = false;

    public Engine()
    {
        electricMotorsList= new ArrayList<>();

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

    public int getSpeedEnergyRatio()
    {
        return speed*25;
    }

    public void switchOn()
    {
        isOn=true;
    }

    public void switchOff()
    {
        isOn=false;
    }

    public boolean isOn() {
        return isOn;
    }
}

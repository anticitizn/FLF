package Display;

import Engine.BatteryManagement;

public class BatteryDisplay {

    private BatteryManagement batteryManagement;

    public BatteryDisplay(BatteryManagement batteryManagement)
    {
        this.batteryManagement=batteryManagement;

        setBatteryManagement(batteryManagement);
    }

    public BatteryManagement getBatteryManagement() {
        return batteryManagement;
    }

    public void setBatteryManagement(BatteryManagement batteryManagement) {
        this.batteryManagement = batteryManagement;
    }


    public double chargeToPercent()
    {
        double varPercentEnergy = batteryManagement.getCapacity();
        double percentEnergy = (varPercentEnergy*100)/400000;
        return percentEnergy;
    }

    public void showPercentEnergy()
    {
        System.out.println("The mean value of the rest energy from all four batteris is " + chargeToPercent() + "%");
    }
}

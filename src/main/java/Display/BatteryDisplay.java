package Display;

import Engine.BatteryManagement;

public class BatteryDisplay {

    private BatteryManagement batteryManagement;

    public BatteryDisplay()
    {

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
        return (varPercentEnergy*100)/400000;
    }

    public void showPercentEnergy()
    {
        System.out.println("The mean value of the rest energy from all four batteries is " + chargeToPercent() + "%");
    }
}

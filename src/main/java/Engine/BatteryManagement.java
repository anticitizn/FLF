package Engine;

import java.util.ArrayList;

public class BatteryManagement {
    private final ArrayList<Battery> batteryBox;

    public BatteryManagement()
    {
        batteryBox=new ArrayList<>();

        batteryBox.add(new Battery());
        batteryBox.add(new Battery());
        batteryBox.add(new Battery());
        batteryBox.add(new Battery());
    }

    public ArrayList<Battery> getBatteryBox() {
        return batteryBox;
    }

    public void charge(int amount)
    {
        for (Battery box : batteryBox) {
            box.charge(amount);
        }
    }

    public void drain(int amount)
    {
        int amountOut = amount / 4;

        for (Battery box : batteryBox) {
            box.drain(amountOut);
        }
    }

    public int getCapacity()
    {
        int capacityCombined=0;

        for (Battery box : batteryBox) {
            capacityCombined = capacityCombined + box.getCapacity();
        }

        return capacityCombined;
    }
}

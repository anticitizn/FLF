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
        for (int i = 0; i < batteryBox.size(); i++) {
            batteryBox.get(i).charge(amount);
        }
    }

    public void drain(int amount)
    {
        int amountOut = amount / 4;

        for (int i = 0; i < batteryBox.size(); i++) {
            batteryBox.get(i).drain(amountOut);
        }
    }

    public int getCapacity()
    {
        int capacityCombined=0;

        for (int i = 0; i < batteryBox.size(); i++) {
            capacityCombined=capacityCombined+batteryBox.get(i).getCapacity();
        }

        return capacityCombined;
    }
}

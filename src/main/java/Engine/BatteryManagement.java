package Engine;

@SuppressWarnings("ALL")
public class BatteryManagement {
    private final Battery[][] batteryBox = new Battery[2][2];

    public BatteryManagement()
    {
        batteryBox[0][0] = new Battery();
        batteryBox[0][1] = new Battery();
        batteryBox[1][0] = new Battery();
        batteryBox[1][1] = new Battery();

        batteryBox[0][0].charge(100000);
        batteryBox[0][1].charge(100000);
        batteryBox[1][0].charge(100000);
        batteryBox[1][1].charge(100000);
    }


    public Battery[][] getBatteryBox() {
        return batteryBox;
    }

    public void charge(int amount)
    {
        for (int i = 0; i < batteryBox.length; i++) {
            for (int j = 0; j < batteryBox[i].length; j++) {
                batteryBox[i][j].charge(amount);
            }
        }
    }



    public void drain(int amount)
    {
        int amountOut = amount / 4;

        for (int i = 0; i < batteryBox.length; i++) {
            for (int j = 0; j < batteryBox[i].length; j++) {
                batteryBox[i][j].drain(amountOut);
            }
        }
    }



    public int getCapacity()
    {
        int capacityCombined=0;

        for (int i = 0; i < batteryBox.length; i++) {
            for (int j = 0; j < batteryBox[i].length; j++) {
                capacityCombined = capacityCombined + batteryBox[i][j].getCapacity();
            }
        }

        return capacityCombined;
    }


}

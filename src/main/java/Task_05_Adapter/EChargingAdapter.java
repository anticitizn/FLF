package Task_05_Adapter;

import Engine.BatteryManagement;

public class EChargingAdapter extends ChargingStationWith1Pole implements IEChargingStation{

    private final BatteryManagement batteryManagement;

    public EChargingAdapter(int amount, BatteryManagement batteryManagement) {
        super(amount);
        this.batteryManagement=batteryManagement;
    }

    public void chargeWith3Poles(int[] amount){
        amount[0]= (int) (chargeWith1Pole()*0.3);
        amount[1]= (int) (chargeWith1Pole()*0.3);
        amount[2]= (int) (chargeWith1Pole()*0.4);
        batteryManagement.chargeWith3Poles(amount);
    }
}

package Task_05_Adapter;


public class ChargingStationWith1Pole {

    private final int amount;

    public ChargingStationWith1Pole(int amount){
        this.amount=amount;
    }

    public int chargeWith1Pole(){
        return amount;
    }
}

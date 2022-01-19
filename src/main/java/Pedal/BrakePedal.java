package Pedal;

import CentralUnit.CentralUnit;

public class BrakePedal extends Pedal{

    public BrakePedal(CentralUnit centralUnit)
    {
        super(centralUnit);
    }

    public void press() {
        centralUnit.brakePedalPressed();
    }
}

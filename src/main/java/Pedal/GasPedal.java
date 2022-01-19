package Pedal;

import CentralUnit.CentralUnit;

public class GasPedal extends Pedal{

    public GasPedal(CentralUnit centralUnit)
    {
        super(centralUnit);
    }

    public void press() {
        centralUnit.gasPedalPressed();
    }
}

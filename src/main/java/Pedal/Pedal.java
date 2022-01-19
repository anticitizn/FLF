package Pedal;

import CentralUnit.CentralUnit;

public abstract class Pedal {

    protected final CentralUnit centralUnit;

    public Pedal(CentralUnit centralUnit)
    {
        this.centralUnit = centralUnit;
    }

    public void press() {}
}

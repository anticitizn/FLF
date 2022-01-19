package Pedal;

public class GasPedal extends Pedal{

    public GasPedal()
    {
        super();
    }

    public void press() {
        centralUnit.gasPedalPressed();
    }
}

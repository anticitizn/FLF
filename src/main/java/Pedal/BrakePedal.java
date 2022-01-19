package Pedal;

public class BrakePedal extends Pedal{

    public BrakePedal()
    {
        super();
    }

    public void press() {
        centralUnit.brakePedalPressed();
    }
}

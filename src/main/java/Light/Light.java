package Light;

import Position.Position;

import java.util.ArrayList;

public abstract class Light implements ILight {

    protected boolean isOn=false;
    protected Position position;
    protected ArrayList<LED> led;
    protected int ledAmount;

    public Light(Position position, int ledAmount)
    {
        this.position=position;
        this.ledAmount=ledAmount;

        led= new ArrayList<>();

        for (int i = 0; i < ledAmount; i++) {
            led.add(new LED());
        }

    }

}

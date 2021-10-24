package Light;

import Position.Position;

public class RoofLight extends Light{

    public RoofLight(Position position,int ledAmount){
        super(position, ledAmount);
    }

    public void switchOn()
    {
        isOn=true;
    }

    public void switchOff()
    {
        isOn=false;
    }

    public boolean checkIsOn()
    {
        return isOn;
    }

    public Position getPosition()
    {
        return position;
    }

    public int getLEDAmount()
    {
        return led.size();
    }
}

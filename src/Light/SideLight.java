package Light;

import Position.Position;

public class SideLight extends Light {
    public SideLight(Position position, int ledAmount){
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

    public int getLEDAmount()
    {
        return led.size();
    }

    public Position getPosition()
    {
        return position;
    }
}

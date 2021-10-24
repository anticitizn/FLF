package Light;

import Position.Position;

public class BlueLight extends Light {

    private BlueLightSize size;

    public BlueLight(Position position, int ledAmount, BlueLightSize size){
        super(position, ledAmount);
        this.size=size;
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

    public BlueLightSize getSize()
    {
        return size;
    }
}

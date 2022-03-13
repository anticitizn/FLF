package Light;

import Position.Position;
import Task_02_SOA.SwitchBlueLightOnEvent;
import com.google.common.eventbus.Subscribe;

public class BreakingLight extends Light {

    public BreakingLight(Position position, int ledAmount){
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

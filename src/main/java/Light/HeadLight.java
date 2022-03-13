package Light;

import Position.Position;
import Task_02_SOA.*;
import com.google.common.eventbus.Subscribe;

public class HeadLight extends Light {

    public HeadLight(Position position, int ledAmount){
        super(position, ledAmount);
    }

    @Subscribe
    public void receive(SwitchHeadLightOnEvent event) {
        isOn = true;
    }

    @Subscribe
    public void receive(SwitchHeadLightOffEvent event) {
        isOn = false;
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

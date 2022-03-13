package Light;

import Position.Position;
import Task_02_SOA.*;
import com.google.common.eventbus.Subscribe;

public class SideLight extends Light {
    public SideLight(Position position, int ledAmount){
        super(position, ledAmount);
    }

    @Subscribe
    public void receive(SwitchSideLightOnEvent event) {
        isOn = true;
    }

    @Subscribe
    public void receive(SwitchSideLightOffEvent event) {
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

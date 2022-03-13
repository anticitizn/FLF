package Light;

import Position.Position;
import Task_02_SOA.*;
import com.google.common.eventbus.Subscribe;

public class WarningLight extends Light {

    public WarningLight(Position position, int ledAmount){
        super(position, ledAmount);
    }

    @Subscribe
    public void receive(SwitchWarningLightOnEvent event) {
        isOn = true;
    }

    @Subscribe
    public void receive(SwitchWarningLightOffEvent event) {
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

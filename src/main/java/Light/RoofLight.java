package Light;

import Position.Position;
import Task_02_SOA.*;
import com.google.common.eventbus.Subscribe;

public class RoofLight extends Light {

    public RoofLight(Position position, int ledAmount){
        super(position, ledAmount);
    }

    @Subscribe
    public void receive(SwitchRoofLightOnEvent event) {
        isOn = true;
    }

    @Subscribe
    public void receive(SwitchRoofLightOffEvent event) {
        isOn = false;
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

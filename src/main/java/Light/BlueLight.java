package Light;

import Position.Position;
import Task_02_SOA.*;
import com.google.common.eventbus.Subscribe;

public class BlueLight extends Light {

    private final BlueLightSize size;

    public BlueLight(Position position, int ledAmount, BlueLightSize size){
        super(position, ledAmount);
        this.size=size;
    }

    @Subscribe
    public void receive(SwitchBlueLightOnEvent event) {
        isOn = true;
    }

    @Subscribe
    public void receive(SwitchBlueLightOffEvent event) {
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

    public BlueLightSize getSize()
    {
        return size;
    }
}

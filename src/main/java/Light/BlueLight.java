package Light;

import Position.Position;
import Task_02_SOA.SwitchBlueLightEvent;
import com.google.common.eventbus.Subscribe;

public class BlueLight extends Light {

    private final BlueLightSize size;

    public BlueLight(Position position, int ledAmount, BlueLightSize size){
        super(position, ledAmount);
        this.size=size;
    }

    @Subscribe
    public void receive(SwitchBlueLightEvent event) {
        isOn = !isOn;
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

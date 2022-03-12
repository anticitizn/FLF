package Light;

import Position.Position;
import Task_02_SOA.SwitchBlueLightEvent;
import com.google.common.eventbus.Subscribe;

public class BreakingLight extends Light {

    public BreakingLight(Position position, int ledAmount){
        super(position, ledAmount);
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
}

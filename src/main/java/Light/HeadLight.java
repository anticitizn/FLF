package Light;

import Position.Position;
import Task_02_SOA.SwitchHeadLightEvent;
import com.google.common.eventbus.Subscribe;

public class HeadLight extends Light {

    public HeadLight(Position position, int ledAmount){
        super(position, ledAmount);
    }

    @Subscribe
    public void receive(SwitchHeadLightEvent event) {
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

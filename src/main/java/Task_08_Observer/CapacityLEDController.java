package Task_08_Observer;

import Light.LED;
import Light.LightColor;

public class CapacityLEDController implements ITankCapacityListener {
    private LED led;

    public CapacityLEDController(LED led) {
        this.led = led;
    }

    @Override
    public void halfCapacity() {
        led.setColor(LightColor.Yellow);
    }

    @Override
    public void quarterCapacity() {
        led.setColor(LightColor.Orange);
    }

    @Override
    public void tenthCapacity() {
        led.setColor(LightColor.Red);
    }
}

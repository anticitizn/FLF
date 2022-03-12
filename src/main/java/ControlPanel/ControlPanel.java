package ControlPanel;

import Engine.Engine;
import Equipment.FrontLauncher;
import Equipment.RoofExtinguishingArm;
import Light.*;
import RotaryButton.RotaryButtonFrontExtinguishingArm;
import RotaryButton.RotaryButtonFrontLauncher;
import Task_02_SOA.Subscriber;
import Task_02_SOA.SwitchRoofLightEvent;
import com.google.common.eventbus.EventBus;

import java.util.ArrayList;


public class ControlPanel {
    private final EventBus eventBus;
    private int eventID;
    private final RotaryButtonFrontExtinguishingArm rotaryButtonFrontExtinguishingArm;
    private final RotaryButtonFrontLauncher rotaryButtonFrontLauncher;
    private final Engine engine;

    public ControlPanel(FrontLauncher frontLauncher, RoofExtinguishingArm roofExtinguishingArm, Engine engine)
    {
        rotaryButtonFrontExtinguishingArm = new RotaryButtonFrontExtinguishingArm(roofExtinguishingArm);
        rotaryButtonFrontLauncher = new RotaryButtonFrontLauncher(frontLauncher);

        this.engine= engine;
        this.eventBus = new EventBus();
    }

    public void addSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public RotaryButtonFrontExtinguishingArm getRotaryButtonFrontExtinguishingArm() {
        return rotaryButtonFrontExtinguishingArm;
    }

    public RotaryButtonFrontLauncher getRotaryButtonFrontLauncher() {
        return rotaryButtonFrontLauncher;
    }

    public void switchRoofLights()
    {
        eventBus.post(new SwitchRoofLightEvent(eventID++));
    }

    public void switchSideLights()
    {
        eventBus.post(new SwitchRoofLightEvent(eventID++));
    }

    public void switchHeadLights()
    {
        eventBus.post(new SwitchRoofLightEvent(eventID++));
    }

    public void switchWarningLights()
    {
        eventBus.post(new SwitchRoofLightEvent(eventID++));
    }

    public void switchBlueLights()
    {
        eventBus.post(new SwitchRoofLightEvent(eventID++));
    }

    public void switchOnEngine()
    {
        engine.switchOn();
    }

    public void switchOffEngine()
    {
        engine.switchOff();
    }

    public void setRotaryButtonFrontExtinguishingArmState(int state)
    {
        rotaryButtonFrontExtinguishingArm.setState(state);
    }

    public void setRotaryButtonFrontLauncherState(int state)
    {
        rotaryButtonFrontLauncher.setState(state);
    }

}

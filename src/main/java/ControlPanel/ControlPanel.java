package ControlPanel;

import Engine.Engine;
import Equipment.FrontLauncher;
import Equipment.RoofExtinguishingArm;
import RotaryButton.RotaryButtonFrontExtinguishingArm;
import RotaryButton.RotaryButtonFrontLauncher;
import CentralUnit.*;

import Task_07_Command.*;

public class ControlPanel {
    private final CentralUnit centralUnit;
    private final RotaryButtonFrontExtinguishingArm rotaryButtonFrontExtinguishingArm;
    private final RotaryButtonFrontLauncher rotaryButtonFrontLauncher;
    private final Engine engine;

    private final Switch blueLightSwitch;
    private final Switch headLightSwitch;
    private final Switch roofLightSwitch;
    private final Switch sideLightSwitch;
    private final Switch warningLightSwitch;

    public ControlPanel(FrontLauncher frontLauncher, RoofExtinguishingArm roofExtinguishingArm, Engine engine, CentralUnit centralUnit)
    {
        rotaryButtonFrontExtinguishingArm = new RotaryButtonFrontExtinguishingArm(roofExtinguishingArm);
        rotaryButtonFrontLauncher = new RotaryButtonFrontLauncher(frontLauncher);
        this.centralUnit = centralUnit;
        this.engine= engine;

        blueLightSwitch = new Switch(new BlueLightOnCommand(centralUnit), new BlueLightOffCommand(centralUnit));
        headLightSwitch = new Switch(new HeadLightOnCommand(centralUnit), new HeadLightOffCommand(centralUnit));
        roofLightSwitch = new Switch(new RoofLightOnCommand(centralUnit), new RoofLightOffCommand(centralUnit));
        sideLightSwitch = new Switch(new SideLightOnCommand(centralUnit), new SideLightOffCommand(centralUnit));
        warningLightSwitch = new Switch(new WarningLightOnCommand(centralUnit), new WarningLightOffCommand(centralUnit));
    }

    public RotaryButtonFrontExtinguishingArm getRotaryButtonFrontExtinguishingArm() {
        return rotaryButtonFrontExtinguishingArm;
    }

    public RotaryButtonFrontLauncher getRotaryButtonFrontLauncher() {
        return rotaryButtonFrontLauncher;
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

    public void switchOnRoofLights()
    {
        roofLightSwitch.on();
    }

    public void switchOffRoofLights()
    {
        roofLightSwitch.off();
    }

    public void switchOnSideLights()
    {
        sideLightSwitch.on();
    }

    public void switchOffSideLights()
    {
        sideLightSwitch.off();
    }

    public void switchOnHeadLights()
    {
        headLightSwitch.on();
    }

    public void switchOffHeadLights()
    {
        headLightSwitch.off();
    }

    public void switchOnWarningLights()
    {
        warningLightSwitch.on();
    }

    public void switchOffWarningLights()
    {
        warningLightSwitch.off();
    }

    public void switchOnBlueLights()
    {
        blueLightSwitch.on();
    }

    public void switchOffBlueLights()
    {
        blueLightSwitch.off();
    }

}

package ControlPanel;

import Engine.Engine;
import Equipment.FrontLauncher;
import Equipment.RoofExtinguishingArm;
import RotaryButton.RotaryButtonFrontExtinguishingArm;
import RotaryButton.RotaryButtonFrontLauncher;
import Task_02_SOA.SwitchRoofLightOffEvent;
import Task_02_SOA.SwitchRoofLightOnEvent;
import CentralUnit.*;


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

        blueLightSwitch = new Switch(SwitchType.BlueLight, centralUnit);
        headLightSwitch = new Switch(SwitchType.HeadLight, centralUnit);
        roofLightSwitch = new Switch(SwitchType.RoofLight, centralUnit);
        sideLightSwitch = new Switch(SwitchType.SideLight, centralUnit);
        warningLightSwitch = new Switch(SwitchType.WarningLight, centralUnit);
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

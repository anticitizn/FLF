package ControlPanel;

import Engine.Engine;
import Equipment.FrontLauncher;
import Equipment.RoofExtinguishingArm;
import Light.*;
import RotaryButton.RotaryButtonFrontExtinguishingArm;
import RotaryButton.RotaryButtonFrontLauncher;

import java.util.ArrayList;


public class ControlPanel {

    private RotaryButtonFrontExtinguishingArm rotaryButtonFrontExtinguishingArm;
    private RotaryButtonFrontLauncher rotaryButtonFrontLauncher;
    private Engine engine;
    private ArrayList<RoofLight> roofLightsList;
    private  ArrayList<SideLight> sideLightList;
    private  ArrayList<HeadLight> headLightList;
    private  ArrayList<BlueLight> blueLightsList;
    private  ArrayList<WarningLight> warningLightList;

    public ControlPanel(FrontLauncher frontLauncher, RoofExtinguishingArm roofExtinguishingArm, Engine engine,
                        ArrayList<RoofLight> roofLightsList, ArrayList<SideLight> sideLightList, ArrayList<HeadLight> headLightList,
                        ArrayList<BlueLight> blueLightsList, ArrayList<WarningLight> warningLightList)
    {
        rotaryButtonFrontExtinguishingArm = new RotaryButtonFrontExtinguishingArm(roofExtinguishingArm);
        rotaryButtonFrontLauncher = new RotaryButtonFrontLauncher(frontLauncher);

        this.engine= engine;

        this.roofLightsList=roofLightsList;
        this.sideLightList=sideLightList;
        this.headLightList=headLightList;
        this.blueLightsList=blueLightsList;
        this.warningLightList=warningLightList;
    }

    public RotaryButtonFrontExtinguishingArm getRotaryButtonFrontExtinguishingArm() {
        return rotaryButtonFrontExtinguishingArm;
    }

    public RotaryButtonFrontLauncher getRotaryButtonFrontLauncher() {
        return rotaryButtonFrontLauncher;
    }

    public void switchOnRoofLights()
    {
        for (RoofLight roofLight : roofLightsList) {
            roofLight.switchOn();
        }
    }

    public void switchOffRoofLights()
    {
        for (RoofLight roofLight : roofLightsList) {
            roofLight.switchOff();
        }
    }

    public void switchOnSideLights()
    {
        for (SideLight sideLight : sideLightList) {
            sideLight.switchOn();
        }
    }

    public void switchOffSideLights()
    {
        for (SideLight sideLight : sideLightList) {
            sideLight.switchOff();
        }
    }

    public void switchOnHeadLights()
    {
        for (HeadLight headLight : headLightList) {
            headLight.switchOn();
        }
    }

    public void switchOffHeadLights()
    {
        for (HeadLight headLight : headLightList) {
            headLight.switchOff();
        }
    }

    public void switchOnWarningLights()
    {
        for (WarningLight warningLight : warningLightList) {
            warningLight.switchOn();
        }
    }

    public void switchOffWarningLights()
    {
        for (WarningLight warningLight : warningLightList) {
            warningLight.switchOff();
        }
    }

    public void switchOnBlueLights()
    {
        for (BlueLight bluelight : blueLightsList) {
            bluelight.switchOn();
        }
    }

    public void switchOffBlueLights()
    {
        for (BlueLight bluelight : blueLightsList) {
            bluelight.switchOff();
        }
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

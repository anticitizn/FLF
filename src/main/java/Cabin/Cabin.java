package Cabin;

import ControlPanel.ControlPanel;
import Display.BatteryDisplay;
import Display.SpeedDisplay;
import Door.BusDoor;
import Engine.Engine;
import Equipment.FrontLauncher;
import Equipment.RoofExtinguishingArm;
import Joystick.Joystick;
import Light.*;
import MixingUnit.MixingUnit;
import Pedal.BreakPedal;
import Pedal.GasPedal;
import Position.Position;
import Seats.Seats;
import Steering.SteeringWheel;

import java.util.ArrayList;

public class Cabin {

    private ArrayList<BusDoor> busDoorsList;
    private ArrayList<Seats> seatsList;
    private ControlPanel controlPanel;
    private SteeringWheel steeringWheel;
    private GasPedal gasPedal;
    private BreakPedal breakPedal;
    private SpeedDisplay speedDisplay;
    private BatteryDisplay batteryDisplay;
    private Joystick frontLauncherJoystick;
    private Joystick roofExtinguishingArmJoystick;


    public Cabin(FrontLauncher frontLauncher, RoofExtinguishingArm roofExtinguishingArm, MixingUnit mixingUnit, Engine engine, ArrayList<RoofLight> roofLightsList, ArrayList<SideLight> sideLightList, ArrayList<HeadLight> headLightList,
                 ArrayList<BlueLight> blueLightsList, ArrayList<WarningLight> warningLightList){
        busDoorsList = new ArrayList<>();
        seatsList = new ArrayList<>();
        controlPanel = new ControlPanel(frontLauncher,roofExtinguishingArm, engine, roofLightsList, sideLightList, headLightList, blueLightsList, warningLightList);
        steeringWheel = new SteeringWheel();
        gasPedal = new GasPedal();
        breakPedal = new BreakPedal();
        speedDisplay = new SpeedDisplay();
        batteryDisplay = new BatteryDisplay();

        frontLauncherJoystick = new Joystick(frontLauncher, mixingUnit);
        roofExtinguishingArmJoystick = new Joystick(roofExtinguishingArm, mixingUnit);

        busDoorsList.add(new BusDoor());
        busDoorsList.add(new BusDoor());

        seatsList.add(new Seats(Position.FRONT_LEFT));
        seatsList.add(new Seats(Position.FRONT_RIGHT));
        seatsList.add(new Seats(Position.BACK_LEFT));
        seatsList.add(new Seats(Position.BACK_RIGHT));

    }

    public ArrayList<BusDoor> getBusDoorsList() {
        return busDoorsList;
    }

    public void setBusDoorsList(ArrayList<BusDoor> busDoorsList) {
        this.busDoorsList = busDoorsList;
    }

    public ArrayList<Seats> getSeatsList() {
        return seatsList;
    }

    public void setSeatsList(ArrayList<Seats> seatsList) {
        this.seatsList = seatsList;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(SteeringWheel steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    public GasPedal getGasPedal() {
        return gasPedal;
    }

    public void setGasPedal(GasPedal gasPedal) {
        this.gasPedal = gasPedal;
    }

    public BreakPedal getBreakPedal() {
        return breakPedal;
    }

    public void setBreakPedal(BreakPedal breakPedal) {
        this.breakPedal = breakPedal;
    }

    public SpeedDisplay getSpeedDisplay() {
        return speedDisplay;
    }

    public void setSpeedDisplay(SpeedDisplay speedDisplay) {
        this.speedDisplay = speedDisplay;
    }

    public BatteryDisplay getBatteryDisplay() {
        return batteryDisplay;
    }

    public void setBatteryDisplay(BatteryDisplay batteryDisplay) {
        this.batteryDisplay = batteryDisplay;
    }

    public Joystick getFrontLauncherJoystick() {
        return frontLauncherJoystick;
    }

    public void setFrontLauncherJoystick(Joystick frontLauncherJoystick) {
        this.frontLauncherJoystick = frontLauncherJoystick;
    }

    public Joystick getRoofExtinguishingArmJoystick() {
        return roofExtinguishingArmJoystick;
    }

    public void setRoofExtinguishingArmJoystick(Joystick roofExtinguishingArmJoystick) {
        this.roofExtinguishingArmJoystick = roofExtinguishingArmJoystick;
    }
}

package Cabin;

import CentralUnit.CentralUnit;
import ControlPanel.ControlPanel;
import Display.BatteryDisplay;
import Display.SpeedDisplay;
import Door.BusDoor;
import Engine.Engine;
import Equipment.FrontLauncher;
import Equipment.RoofExtinguishingArm;
import Joystick.AbstractJoystick;
import Light.*;
import MixingUnit.MixingUnit;
import Pedal.BrakePedal;
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
    private BrakePedal brakePedal;
    private SpeedDisplay speedDisplay;
    private BatteryDisplay batteryDisplay;
    private AbstractJoystick frontLauncherJoystick;
    private AbstractJoystick roofExtinguishingArmJoystick;


    public Cabin(Builder builder)
    {
        busDoorsList=builder.busDoorsList;
        seatsList=builder.seatsList;
        speedDisplay=builder.driverBuilder.speedDisplay;
        batteryDisplay=builder.batteryDisplay;
        steeringWheel=builder.driverBuilder.steeringWheel;
        gasPedal=builder.driverBuilder.gasPedal;
        brakePedal=builder.driverBuilder.brakePedal;
        frontLauncherJoystick=builder.driverBuilder.frontLauncherJoystick;
        roofExtinguishingArmJoystick=builder.operatorBuilder.roofExtinguishingArmJoystick;
        controlPanel=builder.operatorBuilder.controlPanel;
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

    public BrakePedal getBrakePedal() {
        return brakePedal;
    }

    public void setBrakePedal(BrakePedal brakePedal) {
        this.brakePedal = brakePedal;
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

    public AbstractJoystick getFrontLauncherJoystick() {
        return frontLauncherJoystick;
    }

    public void setFrontLauncherJoystick(AbstractJoystick frontLauncherJoystick) {
        this.frontLauncherJoystick = frontLauncherJoystick;
    }

    public AbstractJoystick getRoofExtinguishingArmJoystick() {
        return roofExtinguishingArmJoystick;
    }

    public void setRoofExtinguishingArmJoystick(AbstractJoystick roofExtinguishingArmJoystick) {
        this.roofExtinguishingArmJoystick = roofExtinguishingArmJoystick;
    }

    public static class DriverBuilder
    {
        private final SteeringWheel steeringWheel;
        private final SpeedDisplay speedDisplay;
        private final GasPedal gasPedal;
        private final BrakePedal brakePedal;
        private final AbstractJoystick frontLauncherJoystick;

        public DriverBuilder(AbstractJoystick joystick, SteeringWheel steeringWheel, SpeedDisplay speedDisplay, GasPedal gasPedal, BrakePedal brakePedal, FrontLauncher frontLauncher) {
            frontLauncherJoystick = joystick;
            this.steeringWheel=steeringWheel;
            this.speedDisplay = speedDisplay;
            this.gasPedal=gasPedal;
            this.brakePedal=brakePedal;
        }
    }

    public static class OperatorBuilder
    {
        private final ControlPanel controlPanel;
        private final AbstractJoystick roofExtinguishingArmJoystick;

        public OperatorBuilder(AbstractJoystick joystick, FrontLauncher frontLauncher, RoofExtinguishingArm roofExtinguishingArm,
                               Engine engine, ArrayList<RoofLight> roofLightsList, ArrayList<SideLight> sideLightList, ArrayList<HeadLight> headLightList,
                               ArrayList<BlueLight> blueLightsList, ArrayList<WarningLight> warningLightList) {
            controlPanel = new ControlPanel(frontLauncher,roofExtinguishingArm, engine, roofLightsList, sideLightList, headLightList, blueLightsList, warningLightList);
            roofExtinguishingArmJoystick = joystick;
        }
    }

    public static class Builder
    {
        private final ArrayList<BusDoor> busDoorsList;
        private final ArrayList<Seats> seatsList;
        private final BatteryDisplay batteryDisplay;
        private final DriverBuilder driverBuilder;
        private final OperatorBuilder operatorBuilder;

        public Builder(DriverBuilder driverBuilder, OperatorBuilder operatorBuilder, CentralUnit centralUnit)
        {
            busDoorsList = new ArrayList<>();
            seatsList = new ArrayList<>();
            batteryDisplay = new BatteryDisplay();

            busDoorsList.add(new BusDoor(centralUnit));
            busDoorsList.add(new BusDoor(centralUnit));

            seatsList.add(new Seats(Position.FRONT_LEFT));
            seatsList.add(new Seats(Position.FRONT_RIGHT));
            seatsList.add(new Seats(Position.BACK_LEFT));
            seatsList.add(new Seats(Position.BACK_RIGHT));

            this.driverBuilder=driverBuilder;
            this.operatorBuilder=operatorBuilder;
        }

        public Cabin build()
        {
            return new Cabin(this);
        }
    }
}

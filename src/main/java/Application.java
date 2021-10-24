import Display.BatteryDisplay;
import Display.SpeedDisplay;
import Door.BusDoor;
import Engine.BatteryManagement;
import Engine.Engine;
import Light.BlueLight;
import Light.BlueLightSize;
import Light.RoofLight;
import Pedal.GasPedal;
import Position.Position;
import Steering.SteeringAxis;
import Steering.SteeringWheel;
import Tank.FoamPowderTank;
import Tank.WaterTank;
import Engine.Battery;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        BlueLight blueLight = new BlueLight(Position.FRONT_LEFT,3, BlueLightSize.MEDIUM);
        WaterTank waterTank = new WaterTank();
        BusDoor busDoor = new BusDoor();
        Engine engine = new Engine();
        FoamPowderTank foamPowderTank = new FoamPowderTank();
        GasPedal gasPedal = new GasPedal();
        SteeringWheel steeringWheel = new SteeringWheel();
        ArrayList<SteeringAxis> steeringAxisList = new ArrayList<>();
        SpeedDisplay speedDisplay = new SpeedDisplay();
        BatteryDisplay batteryDisplay = new BatteryDisplay(engine.getBatteryManagement());


        steeringAxisList.add(new SteeringAxis());
        steeringAxisList.add(new SteeringAxis());


        System.out.println(blueLight.checkIsOn());
        blueLight.switchOn();
        System.out.println(blueLight.checkIsOn());
        System.out.println(blueLight.getLEDAmount());
        System.out.println(blueLight.getSize());
        System.out.println(blueLight.getPosition());


        System.out.println("-----------------------------");

        System.out.println(busDoor.isOpen());
        busDoor.open();
        System.out.println(busDoor.isOpen());
        System.out.println(busDoor.getInsideDoorButton().getDoorButtonPosition());
        System.out.println(busDoor.getOutsideDoorButton().getDoorButtonPosition());

        System.out.println("-----------------------------");

        waterTank.fill(12500);
        System.out.println(waterTank.getCapacity());
        waterTank.drain(2000);
        System.out.println(waterTank.getCapacity());


        System.out.println("-----------------------------");
        foamPowderTank.fill(2500);
        System.out.println(foamPowderTank.getCapacity());
        foamPowderTank.drain(500);
        System.out.println(foamPowderTank.getCapacity());
        System.out.println("-----------------------------");

        engine.getBatteryManagement().charge(100000);
        System.out.println(engine.getBatteryManagement().getCapacity());

        for (int i = 0; i < 20; i++) {
            gasPedal.press();
        }
        engine.setSpeed(gasPedal.getSpeed());
        engine.getBatteryManagement().drain(engine.speedEnergyRatio(engine.getSpeed()));
        System.out.println(engine.getBatteryManagement().getCapacity());

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        steeringWheel.setRotation(5);

        for (int i = 0; i < steeringAxisList.size(); i++) {
            steeringAxisList.get(i).setRotation(steeringWheel.getRotation());
            System.out.println(steeringAxisList.get(i).getRotation());
        }

        System.out.println(steeringWheel.getRotation());

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        speedDisplay.setSpeed(engine.getSpeed());
        speedDisplay.showSpeed();

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        batteryDisplay.showPercentEnergy();
    }
}

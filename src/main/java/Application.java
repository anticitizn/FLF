import Cabin.Cabin;
import Display.BatteryDisplay;
import Display.SpeedDisplay;
import Door.BusDoor;
import Engine.BatteryManagement;
import Engine.Engine;
import Light.BlueLight;
import Light.BlueLightSize;
import Light.RoofLight;
import Pedal.GasPedal;
import Person.Driver;
import Person.Operator;
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

        Engine engine = new Engine();
        FoamPowderTank foamPowderTank = new FoamPowderTank();

        ArrayList<SteeringAxis> steeringAxisList = new ArrayList<>();


        Cabin cabin = new Cabin();
        Driver driver = new Driver(1,"Elon","Musk","28.6.1971");
        Operator operator = new Operator(2,"Jeff","Bezos","12.1.1964");

        cabin.getSeatsList().get(0).setDriver(driver);
        cabin.getSeatsList().get(1).setOperator(operator);

        cabin.getBatteryDisplay().setBatteryManagement(engine.getBatteryManagement());

        driver.setSteeringWheel(cabin.getSteeringWheel());
        driver.setGasPedal(cabin.getGasPedal());
        driver.setBreakPedal(cabin.getBreakPedal());



        steeringAxisList.add(new SteeringAxis());
        steeringAxisList.add(new SteeringAxis());


        System.out.println(blueLight.checkIsOn());
        blueLight.switchOn();
        System.out.println(blueLight.checkIsOn());
        System.out.println(blueLight.getLEDAmount());
        System.out.println(blueLight.getSize());
        System.out.println(blueLight.getPosition());


        System.out.println("-----------------------------");


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


        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        //Check Cabin-Doors
        for (int i = 0; i < cabin.getBusDoorsList().size(); i++) {
            cabin.getBusDoorsList().get(i).open();
            System.out.println(cabin.getBusDoorsList().get(i).isOpen());
            System.out.println(cabin.getBusDoorsList().get(i).getInsideDoorButton().getDoorButtonPosition());
            System.out.println(cabin.getBusDoorsList().get(i).getOutsideDoorButton().getDoorButtonPosition());
        }

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        //Check if driver and operator are sitting on front_left and front_right seat
        System.out.println( cabin.getSeatsList().get(0).getDriver());
        System.out.println( cabin.getSeatsList().get(1).getOperator());

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        //Check if driver can press gaspedal and check correct enegery + speed amount
        for (int i = 0; i < 20; i++) {
           driver.getGasPedal().press();
        }
        engine.setSpeed(driver.getGasPedal().getSpeed());
        engine.getBatteryManagement().drain(engine.speedEnergyRatio(engine.getSpeed()));
        System.out.println(engine.getBatteryManagement().getCapacity());

        cabin.getSpeedDisplay().setSpeed(engine.getSpeed());
        cabin.getSpeedDisplay().showSpeed();

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        //Check rotation of steering wheel is correctly transfered to the steering axis
        driver.getSteeringWheel().setRotation(5);

        for (int i = 0; i < steeringAxisList.size(); i++) {
            steeringAxisList.get(i).setRotation(driver.getSteeringWheel().getRotation());
            System.out.println("Steering Axis rotation = " + steeringAxisList.get(i).getRotation());
        }

        System.out.println("SteeringWheel Rotation = "+driver.getSteeringWheel().getRotation());

    }
}

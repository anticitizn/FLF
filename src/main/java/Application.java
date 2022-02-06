import Engine.Engine;
import FLF.FLF;
import Person.Driver;
import Person.Operator;
import Tank.FoamPowderTank;
import Tank.WaterTank;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class Application {

    public static void main(String[] args) {

        FLF flf = new FLF.Builder(new Engine(), new WaterTank(), new FoamPowderTank()).build();


        Driver driver = new Driver(1,"Elon","Musk","28.6.1971");
        Operator operator = new Operator(2,"Jeff","Bezos","12.1.1964");

        flf.getCabin().getSeatsList().get(0).setDriver(driver);
        flf.getCabin().getSeatsList().get(1).setOperator(operator);


        SecretKey secretKey = driver.getIdCard().getRfidChip().getMyDesKey();
        Cipher cipher = driver.getIdCard().getRfidChip().getDesCipher();
        byte[] encryption = driver.getIdCard().getRfidChip().encrypt(secretKey,cipher);
        flf.getCabin().getBusDoorsList().get(0).getReceiverModule().insertIDCard(encryption);
        flf.getCentralUnit().decrypt(flf.getCentralUnit().getEncryption(), secretKey, cipher);

        //lock the door. You cant open it.
        flf.getCentralUnit().checkDecryptedString();
        flf.getCabin().getBusDoorsList().get(0).setIsLocked(flf.getCentralUnit().getIsLocked());
        flf.getCabin().getBusDoorsList().get(0).open();

        //unlock the door. Now it can be opened again
        flf.getCentralUnit().checkDecryptedString();
        flf.getCabin().getBusDoorsList().get(0).setIsLocked(flf.getCentralUnit().getIsLocked());
        flf.getCabin().getBusDoorsList().get(0).open();
        System.out.println("Door is open: "+flf.getCabin().getBusDoorsList().get(0).isOpen());



        flf.getCabin().getBatteryDisplay().setBatteryManagement(flf.getEngine().getBatteryManagement());

        driver.setSteeringWheel(flf.getCabin().getSteeringWheel());
        driver.setGasPedal(flf.getCabin().getGasPedal());
        driver.setBreakPedal(flf.getCabin().getBrakePedal());
        operator.setControlPanel((flf.getCabin().getControlPanel()));

        for (int i = 0; i < flf.getBlueLightsList().size(); i++) {
            System.out.println(flf.getBlueLightsList().get(i).checkIsOn());
            flf.getBlueLightsList().get(i).switchOn();
            System.out.println(flf.getBlueLightsList().get(i).checkIsOn());
            System.out.println(flf.getBlueLightsList().get(i).getLEDAmount());
            System.out.println(flf.getBlueLightsList().get(i).getSize());
            System.out.println(flf.getBlueLightsList().get(i).getPosition());
        }

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        System.out.println(flf.getWaterTank().getCapacity());
        System.out.println(flf.getWaterTank().getCapacity());

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        flf.getFoamPowderTank().fill(2500);
        System.out.println(flf.getFoamPowderTank().getCapacity());
        flf.getFoamPowderTank().drain(500);
        System.out.println(flf.getFoamPowderTank().getCapacity());

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        flf.getEngine().getBatteryManagement().charge(100000);
        System.out.println(flf.getEngine().getBatteryManagement().getCapacity());

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        //Check Cabin-Doors
        for (int i = 0; i < flf.getCabin().getBusDoorsList().size(); i++) {
            flf.getCabin().getBusDoorsList().get(i).open();
            System.out.println(flf.getCabin().getBusDoorsList().get(i).isOpen());
            System.out.println(flf.getCabin().getBusDoorsList().get(i).getInsideDoorButton().getDoorButtonPosition());
            System.out.println(flf.getCabin().getBusDoorsList().get(i).getOutsideDoorButton().getDoorButtonPosition());
        }

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        //Check if driver and operator are sitting on front_left and front_right seat
        System.out.println(flf.getCabin().getSeatsList().get(0).getDriver());
        System.out.println(flf.getCabin().getSeatsList().get(1).getOperator());

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        //Check if driver can press gasPedal and check correct energy + speed amount
        for (int i = 0; i < 20; i++) {
           driver.getGasPedal().press();
        }

        flf.getEngine().getBatteryManagement().drain(flf.getEngine().speedEnergyRatio(flf.getEngine().getSpeed()));
        System.out.println(flf.getEngine().getBatteryManagement().getCapacity());

        flf.getCabin().getSpeedDisplay().showSpeed();

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        //Check rotation of steering wheel is correctly transferred to the steering axis
        driver.getSteeringWheel().setRotation(5);

        for (int i = 0; i < flf.getSteeringAxesList().size(); i++) {
            flf.getSteeringAxesList().get(i).setRotation(driver.getSteeringWheel().getRotation());
            System.out.println("Steering Axis rotation = " + flf.getSteeringAxesList().get(i).getRotation());
        }

        System.out.println("SteeringWheel Rotation = "+driver.getSteeringWheel().getRotation());

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        flf.getCabin().getControlPanel().setRotaryButtonFrontLauncherState(2);

        flf.getCabin().getFrontLauncherJoystick().pressLeftButton();
        flf.getCabin().getFrontLauncherJoystick().pressRightButton();
        flf.getCabin().getFrontLauncherJoystick().pressBackButton();

        System.out.println(flf.getWaterTank().getCapacity());
        System.out.println(flf.getFoamPowderTank().getCapacity());

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");



    }
}

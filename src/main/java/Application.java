import CentralUnit.CentralUnit;
import Configuration.Configuration;
import Engine.Engine;
import Equipment.FloorSprayNozzle;
import FLF.FLF;
import ID.IDCard;
import Person.Driver;
import Person.Operator;
import Tank.FoamPowderTank;
import Tank.WaterTank;
import Task_01_Component.MixingUnitComponent;
import Task_05_Adapter.EChargingAdapter;
import Task_05_Adapter.IEChargingStation;
import Task_09_Visitor.IVisitable;


import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {


        FLF flf = new FLF.Builder(new Engine(), new WaterTank(), new FoamPowderTank()).build();

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("C:\\Program Files\\Java\\jdk-17.0.1\\bin\\jarsigner", "-verify", "jar/mixingUnit.jar");
            Process process = processBuilder.start();
            process.waitFor();

            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            boolean isComponentAccepted = false;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                if (line.contains("verified")) {
                    isComponentAccepted = true;
                }
            }

            if (isComponentAccepted) {
                System.out.println("component accepted");
            } else {
                System.out.println("component rejected");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        MixingUnitComponent mixingUnitComponent = new MixingUnitComponent(flf);

        flf.getFrontLauncher().setMixingUnitComponent(mixingUnitComponent);
        flf.getRoofExtinguishingArm().setMixingUnitComponent(mixingUnitComponent);

        flf.getCabin().getFrontLauncherJoystick().setMixingUnitComponent(mixingUnitComponent);
        flf.getCabin().getRoofExtinguishingArmJoystick().setMixingUnitComponent(mixingUnitComponent);

        System.out.println(flf.getFrontLauncher().getOutputRate());
        mixingUnitComponent.switchRatio(flf.getFrontLauncher());
        mixingUnitComponent.switchRatio(flf.getFrontLauncher());
        mixingUnitComponent.switchRatio(flf.getFrontLauncher());

        System.out.println("water tank capacity: "+ flf.getWaterTank().getCapacity());

        mixingUnitComponent.drain(100, flf.getFrontLauncher());

        System.out.println("water tank capacity: "+ flf.getWaterTank().getCapacity());

        mixingUnitComponent.switchRatio(flf.getFrontLauncher());
        mixingUnitComponent.switchRatio(flf.getFrontLauncher());

        mixingUnitComponent.drain(200, flf.getFrontLauncher());

        System.out.println("water tank capacity: "+ flf.getWaterTank().getCapacity());

        mixingUnitComponent.switchRatio(flf.getFrontLauncher());

        mixingUnitComponent.drain(200, flf.getFrontLauncher());

        System.out.println("water tank capacity: "+ flf.getWaterTank().getCapacity());

        mixingUnitComponent.switchRatio(flf.getRoofExtinguishingArm());
        mixingUnitComponent.switchRatio(flf.getRoofExtinguishingArm());

        mixingUnitComponent.drain(200, flf.getRoofExtinguishingArm());

        System.out.println("water tank capacity: "+ flf.getWaterTank().getCapacity());

        System.out.println("------------------------------------------------------");


        Driver driver = new Driver(1,"Elon","Musk","28.6.1971", flf.getCabin().getFrontLauncherJoystick());
        Operator operator = new Operator(2,"Jeff","Bezos","12.1.1964", flf.getCabin().getRoofExtinguishingArmJoystick());


        flf.getCabin().getSeatsList().get(0).setDriver(driver);
        flf.getCabin().getSeatsList().get(1).setOperator(operator);

        driver.setIdCard(new IDCard(driver.getID(),driver.getFirstName(),driver.getLastName(), Configuration.instance.encryptionAES));

        String driverEncryptionAES = driver.getIdCard().getRfidChip().doEncryption(driver.createEncryptedString());
        System.out.println("AES Encryption: "+driverEncryptionAES);
        System.out.println();

        driver.setIdCard(new IDCard(driver.getID(),driver.getFirstName(),driver.getLastName(),Configuration.instance.encryptionRSA));

        String driverEncryptionRSA = driver.getIdCard().getRfidChip().doEncryption(driver.createEncryptedString());
        System.out.println("RSA Encryption: "+driverEncryptionRSA);
        System.out.println();

        driver.setIdCard(new IDCard(driver.getID(),driver.getFirstName(),driver.getLastName(),Configuration.instance.encryptionDES));

        String driverEncryptionDES = driver.getIdCard().getRfidChip().doEncryption(driver.createEncryptedString());
        System.out.println("DES Encryption: "+driverEncryptionDES);
        System.out.println();



        System.out.println("------------------------------------------------------");

        flf.getCabin().getBatteryDisplay().setBatteryManagement(flf.getEngine().getBatteryManagement());

        driver.setSteeringWheel(flf.getCabin().getSteeringWheel());
        driver.setGasPedal(flf.getCabin().getGasPedal());
        driver.setBreakPedal(flf.getCabin().getBrakePedal());
        operator.setControlPanel((flf.getCabin().getControlPanel()));

        flf.getEngine().getBatteryManagement().drain(100000);
        System.out.println(flf.getEngine().getBatteryManagement().getCapacity());

        int[] amount = new int[3];
        amount[0]=300;
        amount[1]=300;
        amount[2]=400;


        flf.getEngine().getBatteryManagement().chargeWith3Poles(amount);
        System.out.println(flf.getEngine().getBatteryManagement().getCapacity());

        IEChargingStation onePoleCharger = new EChargingAdapter(1000, flf.getEngine().getBatteryManagement());
        onePoleCharger.chargeWith3Poles(new int[3]);
        System.out.println(flf.getEngine().getBatteryManagement().getCapacity());

        System.out.println("------------------------------------------------------");

        for (int i = 0; i < flf.getEngine().getBatteryManagement().getBatteryBox().length; i++) {
            for (int j = 0; j < flf.getEngine().getBatteryManagement().getBatteryBox()[i].length; j++) {
                System.out.println("MainCell-Count:"+flf.getEngine().getBatteryManagement().getBatteryBox()[i][j].getMainCellList().size());
                System.out.println("SubCell-Count: "+flf.getEngine().getBatteryManagement().getBatteryBox()[i][j].getMainCellList().get(1).getCellList().size());
                System.out.println("SmallCell-Count: "+flf.getEngine().getBatteryManagement().getBatteryBox()[i][j].getMainCellList().get(1).getCellList().get(1).getCellList().size());
                System.out.println("Is Composite: "+flf.getEngine().getBatteryManagement().getBatteryBox()[i][j].getMainCellList().get(1).isComposite());
                System.out.println();
            }
        }

        System.out.println("------------------------------------------------------");

        ArrayList<IVisitable> equipmentList = new ArrayList<>();
        equipmentList.add(flf.getFrontLauncher());
        equipmentList.add(flf.getRoofExtinguishingArm());

        for (FloorSprayNozzle floorSprayNozzle:flf.getFloorSprayNozzleList()) {
            equipmentList.add(floorSprayNozzle);
        }

        CentralUnit visitor = flf.getCentralUnit();

        System.out.println("water tank capacity: "+ flf.getWaterTank().getCapacity());


        if(flf.getEngine().isOn()){
            for (IVisitable equipment:equipmentList) {
                equipment.accept(visitor);
            }
        }else{
            flf.getCentralUnit().switchOnEngine();
            for (IVisitable equipment:equipmentList) {
                equipment.accept(visitor);
            }
        }

        System.out.println("water tank capacity: "+ flf.getWaterTank().getCapacity());


      /*  for (Battery[] batteryBox:flf.getEngine().getBatteryManagement().getBatteryBox()) {
            for (Battery battery:batteryBox ) {
                System.out.println("MainCell-Count:"+ battery.getMainCellList().size());
                for (Cell subCell:battery.getMainCellList()) {
                    System.out.println("    SubCell-Count: "+ subCell.getCellList().size());
                    for (Cell smallCell:subCell.getCellList()) {
                        System.out.println("        SmallCell-Count: "+ smallCell.getCellList().size());
                    }
                }
                System.out.println();
            }
        }*/


        /*SecretKey secretKey = driver.getIdCard().getRfidChip().getMyDesKey();
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

        //Check if driver can press GasPedal and check correct energy + speed amount
        for (int i = 0; i < 20; i++) {
           driver.getGasPedal().press();
        }

        flf.travel();
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
        System.out.println("-----------------------------");*/



    }



}

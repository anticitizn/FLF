import CentralUnit.CentralUnit;
import Configuration.Configuration;
import Engine.Battery;
import Engine.Engine;
import Equipment.FloorSprayNozzle;
import FLF.FLF;
import ID.IDCard;
import Person.Driver;
import Person.Operator;
import Tank.FoamPowderTank;
import Tank.WaterTank;
import Task_01_Component.MixingUnitComponent;
import Task_03_Composite.Cell;
import Task_05_Adapter.EChargingAdapter;
import Task_05_Adapter.IEChargingStation;
import Task_09_Visitor.IVisitable;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestApplicationFLFTeil02 {

    private FLF flf;
    private Driver driver;
    private Operator operator;


    @BeforeEach
    public void setup() {
        flf = new FLF.Builder(new Engine(), new WaterTank(), new FoamPowderTank()).build();
        driver = new Driver(1,"Elon","Musk","28.6.1971", flf.getCabin().getFrontLauncherJoystick());
        operator = new Operator(2,"Jeff","Bezos","12.1.1964", flf.getCabin().getRoofExtinguishingArmJoystick());

        flf.getCabin().getBatteryDisplay().setBatteryManagement(flf.getEngine().getBatteryManagement());

        driver.setSteeringWheel(flf.getCabin().getSteeringWheel());
        driver.setGasPedal(flf.getCabin().getGasPedal());
        driver.setBreakPedal(flf.getCabin().getBrakePedal());
        operator.setControlPanel((flf.getCabin().getControlPanel()));

        MixingUnitComponent mixingUnitComponent = new MixingUnitComponent(flf);

        flf.getFrontLauncher().setMixingUnitComponent(mixingUnitComponent);
        flf.getRoofExtinguishingArm().setMixingUnitComponent(mixingUnitComponent);

        flf.getCabin().getFrontLauncherJoystick().setMixingUnitComponent(mixingUnitComponent);
        flf.getCabin().getRoofExtinguishingArmJoystick().setMixingUnitComponent(mixingUnitComponent);
    }



    @Order(1)
    @Test
    @DisplayName("Component")
    public void mixingUnitComponent() {

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

            assertTrue(isComponentAccepted);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        MixingUnitComponent mixingUnitComponent = new MixingUnitComponent(flf);

        flf.getFrontLauncher().setMixingUnitComponent(mixingUnitComponent);
        flf.getRoofExtinguishingArm().setMixingUnitComponent(mixingUnitComponent);

        flf.getCabin().getFrontLauncherJoystick().setMixingUnitComponent(mixingUnitComponent);
        flf.getCabin().getRoofExtinguishingArmJoystick().setMixingUnitComponent(mixingUnitComponent);

        mixingUnitComponent.switchRatio(flf.getFrontLauncher());
        mixingUnitComponent.switchRatio(flf.getFrontLauncher());
        mixingUnitComponent.switchRatio(flf.getFrontLauncher());

        assertEquals(12500,flf.getWaterTank().getCapacity());

        mixingUnitComponent.drain(100, flf.getFrontLauncher());
        assertEquals(12410,flf.getWaterTank().getCapacity());


        mixingUnitComponent.switchRatio(flf.getRoofExtinguishingArm());
        mixingUnitComponent.switchRatio(flf.getRoofExtinguishingArm());
        mixingUnitComponent.switchRatio(flf.getRoofExtinguishingArm());

        mixingUnitComponent.drain(200, flf.getRoofExtinguishingArm());

        assertEquals(12220,flf.getWaterTank().getCapacity());
    }



    @Order(2)
    @Test
    @DisplayName("SOA and EventBus")
    public void soa()
    {


    }

    @Order(3)
    @Test
    @DisplayName("Composite")
    public void composite()
    {
            // get each Battery of the BatteryBox in the BatteryManagement
        for (Battery[] batteryBox : flf.getEngine().getBatteryManagement().getBatteryBox()) {
            for (Battery battery : batteryBox) {

                //test if each battery has 100 mainCells
                assertEquals(100, battery.getMainCellList().size());

                for (Cell subCell : battery.getMainCellList()) {
                    //test if each mainCell has 100 subCells
                    assertEquals(100, subCell.getCellList().size());

                    for (Cell smallCell : subCell.getCellList()) {
                        //test if each subCell has 10 smallCells
                        assertEquals(10, smallCell.getCellList().size());

                    }
                }

            }
        }

    }

    @Order(4)
    @Test
    @DisplayName("Strategy")
    public void strategy()
    {
        driver.setIdCard(new IDCard(driver.getID(),driver.getFirstName(),driver.getLastName(), Configuration.instance.encryptionAES));

        String driverEncryptionAES = driver.getIdCard().getRfidChip().doEncryption(driver.createEncryptedString());
        System.out.println("AES Encryption: "+driverEncryptionAES);
        System.out.println();

        assertNotEquals("", driverEncryptionAES);

        driver.setIdCard(new IDCard(driver.getID(),driver.getFirstName(),driver.getLastName(),Configuration.instance.encryptionRSA));

        String driverEncryptionRSA = driver.getIdCard().getRfidChip().doEncryption(driver.createEncryptedString());
        System.out.println("RSA Encryption: "+driverEncryptionRSA);
        System.out.println();

        assertNotEquals("", driverEncryptionRSA);

        driver.setIdCard(new IDCard(driver.getID(),driver.getFirstName(),driver.getLastName(),Configuration.instance.encryptionDES));

        String driverEncryptionDES = driver.getIdCard().getRfidChip().doEncryption(driver.createEncryptedString());
        System.out.println("DES Encryption: "+driverEncryptionDES);
        System.out.println();

        assertNotEquals("", driverEncryptionDES);
    }

    @Order(5)
    @Test
    @DisplayName("Adapter")
    public void adapter()
    {
        flf.getEngine().getBatteryManagement().drain(100000);
        System.out.println(flf.getEngine().getBatteryManagement().getCapacity());

        int[] amount = new int[3];
        amount[0]=300;
        amount[1]=300;
        amount[2]=400;

        //Test if normal 3-Pole-Charger is working
        flf.getEngine().getBatteryManagement().chargeWith3Poles(amount);
        System.out.println(flf.getEngine().getBatteryManagement().getCapacity());
        assertEquals(301000, flf.getEngine().getBatteryManagement().getCapacity());

        //Test if 1-Pole-Charger is working
        IEChargingStation onePoleCharger = new EChargingAdapter(1000, flf.getEngine().getBatteryManagement());
        onePoleCharger.chargeWith3Poles(new int[3]);
        assertEquals(302000, flf.getEngine().getBatteryManagement().getCapacity());

    }

    @Order(6)
    @Test
    @DisplayName("State")
    public void state()
    {

    }

    @Order(7)
    @Test
    @DisplayName("command")
    public void command()
    {

    }

    @Order(8)
    @Test
    @DisplayName("Observer")
    public void observer()
    {

    }

    @Order(8)
    @Test
    @DisplayName("Visitor")
    public void visitor()
    {
        ArrayList<IVisitable> equipmentList = new ArrayList<>();
        equipmentList.add(flf.getFrontLauncher());
        equipmentList.add(flf.getRoofExtinguishingArm());

        for (FloorSprayNozzle floorSprayNozzle:flf.getFloorSprayNozzleList()) {
            equipmentList.add(floorSprayNozzle);
        }

        CentralUnit visitor = flf.getCentralUnit();

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

        assertEquals(10800,flf.getWaterTank().getCapacity());

    }

}

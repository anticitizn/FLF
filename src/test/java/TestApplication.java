import Engine.Engine;
import FLF.FLF;
import Person.Driver;
import Person.Operator;
import Tank.FoamPowderTank;
import Tank.WaterTank;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestApplication {

    private FLF flf;
    private Driver driver;
    private Operator operator;


    @BeforeEach
    public void setup() {
        flf = new FLF.Builder(new Engine(), new WaterTank(), new FoamPowderTank()).build();
        driver = new Driver(1,"Elon","Musk","28.6.1971");
        operator = new Operator(2,"Jeff","Bezos","12.1.1964");

        flf.getCabin().getBatteryDisplay().setBatteryManagement(flf.getEngine().getBatteryManagement());

        driver.setSteeringWheel(flf.getCabin().getSteeringWheel());
        driver.setGasPedal(flf.getCabin().getGasPedal());
        driver.setBreakPedal(flf.getCabin().getBrakePedal());
        operator.setControlPanel((flf.getCabin().getControlPanel()));
    }

    public void seatsOccupied(){
        flf.getCabin().getSeatsList().get(0).setDriver(driver);
        flf.getCabin().getSeatsList().get(1).setOperator(operator);

        Assertions.assertNotNull(flf.getCabin().getSeatsList().get(0).getDriver());
        Assertions.assertNotNull(flf.getCabin().getSeatsList().get(1).getOperator());
    }

    public void seatsUnoccuiped()
    {
        for (int i = 0; i < flf.getCabin().getSeatsList().size(); i++) {
            Assertions.assertNull(flf.getCabin().getSeatsList().get(i).getDriver());
            Assertions.assertNull(flf.getCabin().getSeatsList().get(i).getOperator());
        }
    }

    public void engineOff()
    {
        operator.getControlPanel().switchOffEngine();
        Assertions.assertFalse(flf.getEngine().isOn());
    }

    public void engineOn()
    {
        operator.getControlPanel().switchOnEngine();
        Assertions.assertTrue(flf.getEngine().isOn());
    }

    public void allLightsOff()
    {
        operator.getControlPanel().switchOffRoofLights();
        operator.getControlPanel().switchOffSideLights();
        operator.getControlPanel().switchOffHeadLights();
        operator.getControlPanel().switchOffBlueLights();
        operator.getControlPanel().switchOffWarningLights();

        for (int i = 0; i < flf.getRoofLightsList().size(); i++) {
            Assertions.assertFalse(flf.getRoofLightsList().get(i).checkIsOn());
        }
        for (int i = 0; i < flf.getSideLightList().size(); i++) {
            Assertions.assertFalse(flf.getSideLightList().get(i).checkIsOn());
        }
        for (int i = 0; i < flf.getHeadLightList().size(); i++) {
            Assertions.assertFalse(flf.getHeadLightList().get(i).checkIsOn());
        }
        for (int i = 0; i < flf.getBlueLightsList().size(); i++) {
            Assertions.assertFalse(flf.getBlueLightsList().get(i).checkIsOn());
        }
        for (int i = 0; i < flf.getWarningLightList().size(); i++) {
            Assertions.assertFalse(flf.getWarningLightList().get(i).checkIsOn());
        }
    }

    public void allLightsOn()
    {
        operator.getControlPanel().switchOnRoofLights();
        operator.getControlPanel().switchOnSideLights();
        operator.getControlPanel().switchOnHeadLights();
        operator.getControlPanel().switchOnBlueLights();
        operator.getControlPanel().switchOnWarningLights();

        for (int i = 0; i < flf.getRoofLightsList().size(); i++) {
            Assertions.assertTrue(flf.getRoofLightsList().get(i).checkIsOn());
        }
        for (int i = 0; i < flf.getSideLightList().size(); i++) {
            Assertions.assertTrue(flf.getSideLightList().get(i).checkIsOn());
        }
        for (int i = 0; i < flf.getHeadLightList().size(); i++) {
            Assertions.assertTrue(flf.getHeadLightList().get(i).checkIsOn());
        }
        for (int i = 0; i < flf.getBlueLightsList().size(); i++) {
            Assertions.assertTrue(flf.getBlueLightsList().get(i).checkIsOn());
        }
        for (int i = 0; i < flf.getWarningLightList().size(); i++) {
            Assertions.assertTrue(flf.getWarningLightList().get(i).checkIsOn());
        }
    }

    public void busDoorsOpen()
    {
        for (int i = 0; i < flf.getCabin().getBusDoorsList().size(); i++) {
            flf.getCabin().getBusDoorsList().get(i).open();
            Assertions.assertTrue(flf.getCabin().getBusDoorsList().get(i).isOpen());
        }
    }

    public void busDoorsClosed()
    {
        for (int i = 0; i < flf.getCabin().getBusDoorsList().size(); i++) {
            flf.getCabin().getBusDoorsList().get(i).close();
            Assertions.assertFalse(flf.getCabin().getBusDoorsList().get(i).isOpen());
        }
    }

    public void bothTanksFilled()
    {
        Assertions.assertEquals(12500,flf.getWaterTank().getCapacity());
        Assertions.assertEquals(2500,flf.getFoamPowderTank().getCapacity());
    }

    public void batteriesFull()
    {
        for (int i = 0; i < flf.getEngine().getBatteryManagement().getBatteryBox().length; i++) {
            for (int j = 0; j < flf.getEngine().getBatteryManagement().getBatteryBox()[i].length; j++) {
                Assertions.assertEquals(100000, flf.getEngine().getBatteryManagement().getBatteryBox()[i][j].getCapacity());
            }
        }
    }

    public void rotaryButtonsOnState1()
    {
        flf.getCabin().getControlPanel().setRotaryButtonFrontExtinguishingArmState(1);
        flf.getCabin().getControlPanel().setRotaryButtonFrontLauncherState(1);

        Assertions.assertEquals(1,flf.getCabin().getControlPanel().getRotaryButtonFrontExtinguishingArm().getState());
        Assertions.assertEquals(1,flf.getCabin().getControlPanel().getRotaryButtonFrontLauncher().getState());
    }

    public void frontLauncherDeactivated()
    {
        Assertions.assertFalse(flf.getFrontLauncher().isActive());
    }

    public void roofExtinguishingArmRetracted()
    {
        Assertions.assertEquals(0,flf.getRoofExtinguishingArm().getFirstArmSegment().getRotation());
    }

    @Order(1)
    @Test
    @DisplayName("FLF fully created by Builder")
    public void buildComplete() {
        Assertions.assertNotNull(flf);
    }



    @Order(2)
    @Test
    @DisplayName("ControlPanel is working correctly")
    public void usageControlPanel()
    {
        seatsOccupied();

        engineOff();
        allLightsOff();

        engineOn();
        allLightsOn();

    }

    @Order(3)
    @Test
    @DisplayName("Parking works correctly")
    public void handleParking()
    {
        engineOff();
        seatsUnoccuiped();
        busDoorsOpen();
        roofExtinguishingArmRetracted();
        frontLauncherDeactivated();
        allLightsOff();
        bothTanksFilled();
        batteriesFull();
        rotaryButtonsOnState1();
    }

    @Order(4)
    @Test
    @DisplayName("Inspection works correctly")
    public void handleInspectionDrive()
    {
        engineOn();
        seatsOccupied();
        busDoorsClosed();
        roofExtinguishingArmRetracted();
        frontLauncherDeactivated();


        //All lights are off exepct the head lights and the warning lights. So the operator is turning those one on
        allLightsOff();
        operator.getControlPanel().switchOnHeadLights();
        operator.getControlPanel().switchOnWarningLights();

        for (int i = 0; i < flf.getHeadLightList().size(); i++) {
            Assertions.assertTrue(flf.getHeadLightList().get(i).checkIsOn());
        }
        for (int i = 0; i < flf.getWarningLightList().size(); i++) {
            Assertions.assertTrue(flf.getWarningLightList().get(i).checkIsOn());
        }


        bothTanksFilled();
        rotaryButtonsOnState1();


    }

    @Order(5)
    @Test
    @DisplayName("EmergencyService works correctly")
    public void handleEmergencyService()
    {
        engineOn();
        seatsOccupied();
        busDoorsClosed();
        roofExtinguishingArmRetracted();
        frontLauncherDeactivated();


        //All lights are on exepct the side lights.So the operator is turning this one off
        allLightsOn();
        operator.getControlPanel().switchOffSideLights();
        for (int i = 0; i < flf.getSideLightList().size(); i++) {
            Assertions.assertFalse(flf.getSideLightList().get(i).checkIsOn());
        }

        bothTanksFilled();
        rotaryButtonsOnState1();

    }

    @Order(6)
    @Test
    @DisplayName("Fueltruck on Fire  works correctly")
    public void handleFuelTruckOnFire()
    {
        engineOn();
        seatsOccupied();
        busDoorsClosed();
        allLightsOn();
        bothTanksFilled();

    }

    @Order(7)
    @Test
    @DisplayName("Pushback Vehicle on Fire  works correctly")
    public void handlePushbackVehicleOnFire()
    {
        engineOn();
        seatsOccupied();
        busDoorsClosed();
        allLightsOn();
        bothTanksFilled();

    }

    @Order(8)
    @Test
    @DisplayName("Airplane Engine Fire  works correctly")
    public void handleAirplaneEngineFire()
    {
        engineOn();
        seatsOccupied();
        busDoorsClosed();
        allLightsOn();
        bothTanksFilled();

    }







}

import Engine.Engine;
import FLF.FLF;
import Light.*;
import Person.Driver;
import Person.Operator;
import Tank.FoamPowderTank;
import Tank.WaterTank;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        driver.setBreakPedal(flf.getCabin().getBreakPedal());
        operator.setControlPanel((flf.getCabin().getControlPanel()));

    }

    public void seatsOccupied(){
        flf.getCabin().getSeatsList().get(0).setDriver(driver);
        flf.getCabin().getSeatsList().get(1).setOperator(operator);
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
        //operator sitting on seat
        seatsOccupied();

        //check if every switch in ControllPanel is turned off
        //Starting with the engine, then going over the different light-list
        Assertions.assertFalse(flf.getEngine().isOn());
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


        //Operator is turning everything on
        operator.getControlPanel().switchOnEngine();
        operator.getControlPanel().switchOnRoofLights();
        operator.getControlPanel().switchOnSideLights();
        operator.getControlPanel().switchOnHeadLights();
        operator.getControlPanel().switchOnBlueLights();
        operator.getControlPanel().switchOnWarningLights();


        //check if everything is on
        Assertions.assertTrue(flf.getEngine().isOn());
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


}

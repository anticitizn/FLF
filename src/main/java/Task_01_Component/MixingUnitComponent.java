package Task_01_Component;

import Configuration.Configuration;
import FLF.FLF;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class MixingUnitComponent {
    Object muPort;
    FLF flf;

    public MixingUnitComponent(FLF flf){
        this.flf = flf;
        createMixingUnitPortInstance();
    }

    public void createMixingUnitPortInstance() {

        try {
            URL[] urls = {new File(Configuration.instance.pathToJar).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, MixingUnitComponent.class.getClassLoader());
            Class mixingUnitClass = Class.forName("MixingUnit", true, urlClassLoader);

            Object mixingUnitInstance = mixingUnitClass.getMethod("getInstance").invoke(null);
            muPort = mixingUnitClass.getDeclaredField("port").get(mixingUnitInstance);


            Method setData = muPort.getClass().getMethod("setData", Object.class, Object.class, Object.class, Object.class);
            setData.invoke(muPort, flf.getWaterTank(), flf.getFoamPowderTank(), flf.getFrontLauncher(), flf.getRoofExtinguishingArm());


        } catch (Exception e) {
            System.out.println("--- exception");
            System.out.println(e.getMessage());
        }
    }

    public void switchRatio(Object equipmentType) {

        try {
            Method switchRatio = muPort.getClass().getDeclaredMethod("switchRatio", Object.class);
            switchRatio.invoke(muPort, equipmentType);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void setRatio(int ratio, Object equipmentType) {

        try {
            Method setRatio = muPort.getClass().getDeclaredMethod("setRatio", int.class,Object.class);
            setRatio.invoke(muPort, ratio, equipmentType);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void drain(int amount, Object equipmentType) {

        ArrayList<Integer> fluidUsed;
        try {
            Method drain = muPort.getClass().getDeclaredMethod("drain", int.class, Object.class);
            drain.invoke(muPort, amount, equipmentType);

            Method getFluidUsed = muPort.getClass().getDeclaredMethod("getFluidUsed");
            fluidUsed = (ArrayList<Integer>) getFluidUsed.invoke(muPort);

            flf.getFoamPowderTank().drain(fluidUsed.get(0));
            flf.getWaterTank().drain(fluidUsed.get(1));

            fluidUsed.clear();

            Method clearFluid = muPort.getClass().getDeclaredMethod("clearFluidUsed");
            clearFluid.invoke(muPort);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}

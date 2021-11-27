package FLF;

import Cabin.Cabin;
import Engine.Engine;
import Equipment.FloorSprayNozzle;
import Equipment.FrontLauncher;
import Equipment.RoofExtinguishingArm;
import Light.*;
import MixingUnit.MixingUnit;
import Position.Position;
import Steering.BackAxis;
import Steering.SteeringAxis;
import Tank.FoamPowderTank;
import Tank.WaterTank;

import java.util.ArrayList;

public class FLF {

    private final Cabin cabin;
    private final Engine engine;
    private final WaterTank waterTank;
    private final FoamPowderTank foamPowderTank;
    private final ArrayList<BackAxis> backAxesList;
    private final ArrayList<SteeringAxis> steeringAxesList;
    private final ArrayList<RoofLight> roofLightsList;
    private final ArrayList<SideLight> sideLightList;
    private final ArrayList<HeadLight> headLightList;
    private final ArrayList<BlueLight> blueLightsList;
    private final ArrayList<WarningLight> warningLightList;
    private final ArrayList<BreakingLight> breakingLightList;
    private final ArrayList<TurnSignal> turnSignalList;
    private final FrontLauncher frontLauncher;
    private final ArrayList<FloorSprayNozzle> floorSprayNozzleList;
    private final RoofExtinguishingArm roofExtinguishingArm;
    private final MixingUnit mixingUnit;

    protected FLF (Builder builder)
    {
        cabin=builder.cabin;
        engine=builder.engine;
        waterTank=builder.waterTank;
        foamPowderTank=builder.foamPowderTank;
        backAxesList=builder.backAxesList;
        steeringAxesList=builder.steeringAxesList;
        roofLightsList= builder.roofLightsList;
        sideLightList= builder.sideLightList;
        headLightList= builder.headLightList;
        blueLightsList= builder.blueLightsList;
        warningLightList= builder.warningLightList;
        breakingLightList= builder.breakingLightList;
        turnSignalList= builder.turnSignalList;
        frontLauncher= builder.frontLauncher;
        floorSprayNozzleList = builder.floorSprayNozzleList;
        roofExtinguishingArm= builder.roofExtinguishingArm;
        mixingUnit= builder.mixingUnit;
    }

    public Cabin getCabin() {
        return cabin;
    }

    public Engine getEngine() {
        return engine;
    }

    public WaterTank getWaterTank() {
        return waterTank;
    }

    public FoamPowderTank getFoamPowderTank() {
        return foamPowderTank;
    }

    public ArrayList<BackAxis> getBackAxesList() {
        return backAxesList;
    }

    public ArrayList<SteeringAxis> getSteeringAxesList() {
        return steeringAxesList;
    }

    public ArrayList<RoofLight> getRoofLightsList() {
        return roofLightsList;
    }

    public ArrayList<SideLight> getSideLightList() {
        return sideLightList;
    }

    public ArrayList<HeadLight> getHeadLightList() {
        return headLightList;
    }

    public ArrayList<BlueLight> getBlueLightsList() {
        return blueLightsList;
    }

    public ArrayList<WarningLight> getWarningLightList() {
        return warningLightList;
    }

    public ArrayList<BreakingLight> getBreakingLightList() {
        return breakingLightList;
    }

    public ArrayList<TurnSignal> getTurnSignalList() {
        return turnSignalList;
    }

    public FrontLauncher getFrontLauncher() {
        return frontLauncher;
    }

    public ArrayList<FloorSprayNozzle> getFloorSprayNozzleList() {
        return floorSprayNozzleList;
    }

    public RoofExtinguishingArm getRoofExtinguishingArm() {
        return roofExtinguishingArm;
    }

    public MixingUnit getMixingUnit() {
        return mixingUnit;
    }

    public static class Builder
    {
        private Cabin cabin;
        private  Engine engine;
        private  WaterTank waterTank;
        private  FoamPowderTank foamPowderTank;
        private  ArrayList<BackAxis> backAxesList;
        private  ArrayList<SteeringAxis> steeringAxesList;
        private  ArrayList<RoofLight> roofLightsList;
        private  ArrayList<SideLight> sideLightList;
        private  ArrayList<HeadLight> headLightList;
        private  ArrayList<BlueLight> blueLightsList;
        private  ArrayList<WarningLight> warningLightList;
        private  ArrayList<BreakingLight> breakingLightList;
        private  ArrayList<TurnSignal> turnSignalList;
        private final FrontLauncher frontLauncher;
        private final ArrayList<FloorSprayNozzle> floorSprayNozzleList;
        private final RoofExtinguishingArm roofExtinguishingArm;
        private final MixingUnit mixingUnit;

        public Builder( Engine engine, WaterTank waterTank, FoamPowderTank foamPowderTank){

            this.engine=engine;
            this.waterTank=waterTank;
            this.foamPowderTank=foamPowderTank;
            mixingUnit=new MixingUnit(waterTank, foamPowderTank);

            frontLauncher=new FrontLauncher(mixingUnit);
            floorSprayNozzleList = new ArrayList<>();
            for (int i = 0; i <= 6; i++) {
                floorSprayNozzleList.add(new FloorSprayNozzle(waterTank));
            }

            roofExtinguishingArm=new RoofExtinguishingArm(mixingUnit);



            backAxesList = new ArrayList<>();
            for (int i = 0; i <= 1; i++) {
                backAxesList.add(new BackAxis());
            }

            steeringAxesList = new ArrayList<>();
            for (int i = 0; i <= 2; i++) {
                steeringAxesList.add(new SteeringAxis());
            }

            buildLights();

            cabin = new Cabin(frontLauncher,roofExtinguishingArm,mixingUnit,engine, roofLightsList,sideLightList,headLightList,blueLightsList,warningLightList);
        }

        public void buildLights()
        {
            roofLightsList = new ArrayList<>();
            for (int i = 0; i <= 3; i++) {
                roofLightsList.add(new RoofLight(Position.FRONT_ROOF, 1));
            }

            sideLightList = new ArrayList<>();
            for (int i = 0; i <= 4; i++) {
                sideLightList.add(new SideLight(Position.SIDE_LEFT,1));
                sideLightList.add(new SideLight(Position.SIDE_RIGHT,1));
            }

            headLightList = new ArrayList<>();
            for (int i = 0; i <= 5; i++) {
                headLightList.add(new HeadLight(Position.FRONT_LEFT,1));
                headLightList.add(new HeadLight(Position.FRONT_RIGHT,1));
            }

            breakingLightList = new ArrayList<>();
            breakingLightList.add(new BreakingLight(Position.BACK_LEFT,1));
            breakingLightList.add(new BreakingLight(Position.BACK_RIGHT,1));

            turnSignalList = new ArrayList<>();
            turnSignalList.add(new TurnSignal(Position.FRONT_LEFT,1));
            turnSignalList.add(new TurnSignal(Position.BACK_LEFT,1));
            turnSignalList.add(new TurnSignal(Position.FRONT_RIGHT,1));
            turnSignalList.add(new TurnSignal(Position.BACK_RIGHT,1));

            warningLightList = new ArrayList<>();
            warningLightList.add(new WarningLight(Position.FRONT_LEFT_ROOF,1));
            warningLightList.add(new WarningLight(Position.BACK_RIGHT_ROOF,1));

            blueLightsList = new ArrayList<>();
            for (int i = 0; i <= 1; i++) {
                blueLightsList.add(new BlueLight(Position.FRONT,1,BlueLightSize.SMALL));
            }

            for (int i = 0; i <= 1; i++) {
                blueLightsList.add(new BlueLight(Position.FRONT_LEFT_ROOF,4,BlueLightSize.BIG));
                blueLightsList.add(new BlueLight(Position.FRONT_RIGHT_ROOF,4,BlueLightSize.BIG));
            }

            for (int i = 0; i < 1; i++) {
                blueLightsList.add(new BlueLight(Position.BACK_LEFT,2,BlueLightSize.MEDIUM));
                blueLightsList.add(new BlueLight(Position.BACK_LEFT,2,BlueLightSize.MEDIUM));
            }
        }



        public FLF build() {
            return new FLF(this);
        }
    }
}

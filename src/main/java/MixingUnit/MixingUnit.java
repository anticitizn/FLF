package MixingUnit;

import Equipment.EquipmentType;
import Tank.FoamPowderTank;
import Tank.WaterTank;

import java.util.HashMap;

public class MixingUnit {
    private final WaterTank waterTank;
    private final FoamPowderTank foamPowderTank;
    private final HashMap<EquipmentType, Integer> ratios = new HashMap<>();
    int ratioState = 0;

    public MixingUnit(WaterTank WaterTank, FoamPowderTank FoamPowderTank) {
        waterTank = WaterTank;
        foamPowderTank = FoamPowderTank;
        ratios.put(EquipmentType.FrontLauncher, 0);
        ratios.put(EquipmentType.RoofExtinguishingArm, 0);
    }

    public void switchRatio(EquipmentType equipmentType) {
        switch (ratioState) {
            case 0 -> {
                setRatio(3, equipmentType);
                ratioState = 1;
            }
            case 1 -> {
                setRatio(5, equipmentType);
                ratioState = 2;
            }
            case 2 -> {
                setRatio(10, equipmentType);
                ratioState = 3;
            }
            case 3 -> {
                setRatio(0, equipmentType);
                ratioState = 0;
            }
        }
    }

    public void setRatio(int ratio, EquipmentType equipmentType) {
        ratios.put(equipmentType, ratio);
        System.out.println(ratios.get(equipmentType));
    }

    public void drain(int amount, EquipmentType equipmentType) {
        int ratio = ratios.get(equipmentType);
        int foamUsed = (int)(amount * (ratio / 100.0f));
        int waterUsed = amount - foamUsed;

        waterTank.drain(waterUsed);
        foamPowderTank.drain(foamUsed);
    }
}

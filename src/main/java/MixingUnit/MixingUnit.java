package MixingUnit;

import Equipment.EquipmentType;
import Tank.FoamPowderTank;
import Tank.WaterTank;

import java.util.HashMap;

public class MixingUnit {
    private final WaterTank waterTank;
    private final FoamPowderTank foamPowderTank;
    private final HashMap<EquipmentType, Integer> ratios = new HashMap<>();

    public MixingUnit(WaterTank WaterTank, FoamPowderTank FoamPowderTank) {
        waterTank = WaterTank;
        foamPowderTank = FoamPowderTank;
        ratios.put(EquipmentType.FrontLauncher, 0);
        ratios.put(EquipmentType.RoofExtinguishingArm, 0);
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

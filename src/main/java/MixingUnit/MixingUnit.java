package MixingUnit;

import Equipment.EquipmentType;
import Tank.FoamPowderTank;
import Tank.WaterTank;

import java.util.HashMap;

public class MixingUnit {
    private WaterTank waterTank;
    private FoamPowderTank foamPowderTank;
    private final HashMap<EquipmentType, Integer> ratios = new HashMap<EquipmentType, Integer>();

    public void setRatio(int ratio, EquipmentType equipmentType) {
        ratios.put(equipmentType, ratio);
    }

    public void shoot(int amount, EquipmentType equipmentType) {
        int ratio = ratios.get(equipmentType);
        int foamUsed = amount * (ratio / 100);
        int waterUsed = amount - foamUsed;

        waterTank.drain(waterUsed);
        foamPowderTank.drain(foamUsed);
    }
}

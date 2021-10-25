package Equipment;

import MixingUnit.MixingUnit;

public class FrontLauncher extends Equipment {
    private final MixingUnit mixingUnit;
    int rotation = 0;

    public FrontLauncher(MixingUnit MixingUnit) {
        mixingUnit = MixingUnit;
        this.equipmentType = EquipmentType.FrontLauncher;
    }

    @Override
    public void shoot() {
        mixingUnit.shoot(outputRate, equipmentType);
    }

    @Override
    public void activate() {
        rotation = 90;
        active = true;
    }

    @Override
    public void deactivate() {
        rotation = 0;
        active = false;
    }
}

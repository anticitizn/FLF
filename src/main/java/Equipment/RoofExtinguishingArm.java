package Equipment;

import MixingUnit.MixingUnit;

public class RoofExtinguishingArm extends Equipment {

    private final MixingUnit mixingUnit;
    private final FirstArmSegment firstArmSegment = new FirstArmSegment();
    private final SecondArmSegment secondArmSegment = new SecondArmSegment();

    public RoofExtinguishingArm(MixingUnit MixingUnit) {
        mixingUnit = MixingUnit;
        this.equipmentType = EquipmentType.RoofExtinguishingArm;
    }

    @Override
    public void shoot() {
        mixingUnit.drain(outputRate, equipmentType);
    }

    @Override
    public void activate() {
        firstArmSegment.setRotation(90);
        active = true;
    }

    @Override
    public void deactivate() {
        firstArmSegment.setRotation(0);
        active = false;
    }
}

package Equipment;

import Task_01_Component.MixingUnitComponent;
import Task_09_Visitor.IVisitor;

public class RoofExtinguishingArm extends Equipment {

    private MixingUnitComponent mixingUnitComponent;
    private final FirstArmSegment firstArmSegment = new FirstArmSegment();
    private final SecondArmSegment secondArmSegment = new SecondArmSegment();

    public RoofExtinguishingArm() {

        this.equipmentType = EquipmentType.RoofExtinguishingArm;
    }

    public FirstArmSegment getFirstArmSegment() {
        return firstArmSegment;
    }


    public void setMixingUnitComponent(MixingUnitComponent mixingUnitComponent) {
        this.mixingUnitComponent = mixingUnitComponent;
    }

    @Override
    public void shoot() {
        mixingUnitComponent.drain(outputRate, this);
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

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

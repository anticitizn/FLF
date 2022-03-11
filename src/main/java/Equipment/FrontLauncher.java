package Equipment;

import Task_01_Component.MixingUnitComponent;
import Task_09_Visitor.IVisitor;

public class FrontLauncher extends Equipment {

    private MixingUnitComponent mixingUnitComponent;
    int rotation = 0;

    public FrontLauncher() {

        this.equipmentType = EquipmentType.FrontLauncher;
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
        rotation = 90;
        active = true;
    }

    @Override
    public void deactivate() {
        rotation = 0;
        active = false;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

package Equipment;

import Task_09_Visitor.IVisitable;

public abstract class Equipment implements IEquipment, IVisitable {
    protected int outputRate = 500;
    protected boolean active = false;
    protected EquipmentType equipmentType = EquipmentType.Misc;

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public int getOutputRate() {
        return outputRate;
    }

    @Override
    public void setOutputRate(int outputRate) {
        this.outputRate = outputRate;
    }

    @Override
    public EquipmentType getEquipmentType() {
        return equipmentType;
    }
}

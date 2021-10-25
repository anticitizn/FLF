package Equipment;

public interface IEquipment {
    void shoot();
    int getOutputRate();
    void setOutputRate(int outputRate);
    void activate();
    void deactivate();
    boolean isActive();
    EquipmentType getEquipmentType();
}

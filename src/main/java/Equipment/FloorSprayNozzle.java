package Equipment;

import Tank.WaterTank;
import Task_09_Visitor.IVisitor;

public class FloorSprayNozzle extends Equipment {
    private final WaterTank waterTank;

    public FloorSprayNozzle(WaterTank tank) {
        this.waterTank = tank;
        this.outputRate = 100;
    }

    @Override
    public void shoot() {
        this.waterTank.drain(outputRate);
    }

    @Override
    public void setOutputRate(int outputRate) {
        this.outputRate = Math.min(outputRate, 100); // max output rate = 100
    }

    @Override
    public void activate() {
        active = true;
    }

    @Override
    public void deactivate() {
        active = false;
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

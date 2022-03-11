package Task_09_Visitor;

import Equipment.FloorSprayNozzle;
import Equipment.FrontLauncher;
import Equipment.RoofExtinguishingArm;

public interface IVisitor {

    void visit(FrontLauncher frontLauncher);
    void visit(RoofExtinguishingArm roofExtinguishingArm);
    void visit(FloorSprayNozzle floorSprayNozzle);
}

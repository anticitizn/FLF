package Steering;

import CentralUnit.CentralUnit;

import java.util.UUID;

public class SteeringWheel {
    private final String id;
    private final CentralUnit centralUnit;

    public SteeringWheel(CentralUnit centralUnit) {
        this.centralUnit = centralUnit;
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public int getRotation() {
        return centralUnit.getRotation();
    }

    public void setRotation(int rotation) {
        if(rotation>30)
        {
            rotation=30;
        }
        else if (rotation<-30)
        {
            rotation=-30;
        }

        centralUnit.setRotation(rotation);
    }
}

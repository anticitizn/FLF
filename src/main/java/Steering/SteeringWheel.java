package Steering;

import java.util.UUID;

public class SteeringWheel {

    private String id;
    private int rotation;

    public SteeringWheel(){

        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public int getRotation() {
        return rotation;
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

        this.rotation = rotation;
    }
}

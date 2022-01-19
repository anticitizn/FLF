package Steering;

public class SteeringAxis extends Axes {

    private int rotation = 0;

    public SteeringAxis()
    {
        super();
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getRotation() {
        return rotation;
    }
}

package CentralUnit;

import Engine.Engine;
import Steering.SteeringAxis;

import java.util.ArrayList;

public class CentralUnit {
    private final Engine engine;
    private final ArrayList<SteeringAxis> steeringAxes;

    public CentralUnit(Engine engine, ArrayList<SteeringAxis> steeringAxes) {
        this.engine = engine;
        this.steeringAxes = steeringAxes;
    }

    public int getSpeed() {
        return engine.getSpeed();
    }

    public void gasPedalPressed() {
        engine.setSpeed(engine.getSpeed() + 4);
    }

    public void brakePedalPressed() {
        if (engine.getSpeed() > 4) {
            engine.setSpeed(engine.getSpeed() - 4);
        } else {
            engine.setSpeed(0);
        }
    }

    public void setRotation(int rotation) {
        for (SteeringAxis steeringAxis : steeringAxes) {
            steeringAxis.setRotation(rotation);
        }

    }

    public int getRotation() {
        return steeringAxes.get(0).getRotation();
    }

}

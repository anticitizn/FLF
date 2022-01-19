package CentralUnit;

import Engine.Engine;
import Steering.SteeringAxis;

public class CentralUnit {
    private final Engine engine;
    private final SteeringAxis steeringAxis;

    public CentralUnit(Engine engine, SteeringAxis steeringAxis) {
        this.engine = engine;
        this.steeringAxis = steeringAxis;
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
        steeringAxis.setRotation(rotation);
    }

    public int getRotation() {
        return steeringAxis.getRotation();
    }

}

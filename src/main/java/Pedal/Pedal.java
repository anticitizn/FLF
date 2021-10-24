package Pedal;

public  abstract class Pedal {

    protected int speed=0;

    public Pedal(){}

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

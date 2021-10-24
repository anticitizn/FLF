package Display;

public class SpeedDisplay {

    private int speed=0;

    public SpeedDisplay(){}

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void showSpeed()
    {
        System.out.println("You are driving with a current speed of " + getSpeed() + " km/h.");
    }
}

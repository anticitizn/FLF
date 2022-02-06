package Display;

import CentralUnit.CentralUnit;

@SuppressWarnings({"ALL", "ClassCanBeRecord"})
public class SpeedDisplay {

    private final CentralUnit centralUnit;

    public SpeedDisplay(CentralUnit centralUnit)
    {
        this.centralUnit = centralUnit;
    }

    public int getSpeed() {
        return centralUnit.getSpeed();
    }

    public void showSpeed()
    {
        System.out.println("You are driving with a current speed of " + getSpeed() + " km/h.");
    }
}

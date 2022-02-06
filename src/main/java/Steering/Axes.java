package Steering;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Axes {

    protected final ArrayList<Wheel> wheelList;
    protected final ArrayList<BrakeDiscs> brakeDiscsList;
    protected final String id;

    public Axes()
    {
        wheelList = new ArrayList<>();
        brakeDiscsList = new ArrayList<>();

        addWheels();
        addBrakeDiscs();

        id = UUID.randomUUID().toString();

    }

    public void addWheels()
    {
        for (int i = 0; i <= 1; i++) {
            wheelList.add(new Wheel());
        }
    }

    public void addBrakeDiscs()
    {
        for (int i = 0; i <= 5; i++) {
            brakeDiscsList.add(new BrakeDiscs());
        }
    }

    public ArrayList<BrakeDiscs> getBrakeDiscsList() {
        return brakeDiscsList;
    }

    public ArrayList<Wheel> getWheelList() {
        return wheelList;
    }

    public String getId() {
        return id;
    }
}

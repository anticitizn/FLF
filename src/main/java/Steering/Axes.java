package Steering;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Axes {

    protected ArrayList<Wheel> wheelList;
    protected ArrayList<BrakeDiscs> brakeDiscsList;
    protected String id;

    public Axes()
    {
        wheelList = new ArrayList<>();
        brakeDiscsList = new ArrayList<>();

        addWheels();
        addBrakeDics();

        id = UUID.randomUUID().toString();

    }

    public void addWheels()
    {
        for (int i = 0; i <= 1; i++) {
            wheelList.add(new Wheel());
        }
    }

    public void addBrakeDics()
    {
        for (int i = 0; i <= 5; i++) {
            brakeDiscsList.add(new BrakeDiscs());
        }
    }

    public ArrayList<BrakeDiscs> getBrakeDicsList() {
        return brakeDiscsList;
    }

    public ArrayList<Wheel> getWheelList() {
        return wheelList;
    }

    public String getId() {
        return id;
    }
}

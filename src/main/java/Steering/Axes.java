package Steering;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Axes {

    protected ArrayList<Wheel> wheelList;
    protected ArrayList<BrakeDics> brakeDicsList;
    protected String id;

    public Axes()
    {
        wheelList = new ArrayList<>();
        brakeDicsList = new ArrayList<>();

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
            brakeDicsList.add(new BrakeDics());
        }
    }

    public ArrayList<BrakeDics> getBrakeDicsList() {
        return brakeDicsList;
    }

    public ArrayList<Wheel> getWheelList() {
        return wheelList;
    }

    public String getId() {
        return id;
    }
}

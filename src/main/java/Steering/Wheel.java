package Steering;

import java.util.UUID;

public class Wheel {

    private String id;

    public Wheel(){
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}

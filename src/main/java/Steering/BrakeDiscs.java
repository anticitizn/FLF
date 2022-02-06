package Steering;

import java.util.UUID;

public class BrakeDiscs {

    private final String id;

    public BrakeDiscs(){
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}

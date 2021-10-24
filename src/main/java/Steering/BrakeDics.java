package Steering;

import java.util.UUID;

public class BrakeDics {

    private String id;

    public BrakeDics(){
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}

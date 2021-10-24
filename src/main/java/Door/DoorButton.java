package Door;

public class DoorButton {

    private DoorButtonPosition doorButtonPosition;

    public DoorButton(DoorButtonPosition doorButtonPosition)
    {
        this.doorButtonPosition=doorButtonPosition;
    }

    public DoorButtonPosition getDoorButtonPosition() {
        return doorButtonPosition;
    }
}

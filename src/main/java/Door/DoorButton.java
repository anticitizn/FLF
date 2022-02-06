package Door;

@SuppressWarnings({"ALL", "ClassCanBeRecord"})
public class DoorButton {

    private final DoorButtonPosition doorButtonPosition;

    public DoorButton(DoorButtonPosition doorButtonPosition)
    {
        this.doorButtonPosition=doorButtonPosition;
    }

    public DoorButtonPosition getDoorButtonPosition() {
        return doorButtonPosition;
    }
}

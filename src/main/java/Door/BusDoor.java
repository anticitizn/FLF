package Door;

public class BusDoor {

    private boolean isOpen = false;
    private final DoorButton insideDoorButton;
    private final DoorButton outsideDoorButton;
    private final ReceiverModule receiverModule;

    public BusDoor()
    {
        insideDoorButton=new DoorButton(DoorButtonPosition.INSIDE);
        outsideDoorButton=new DoorButton(DoorButtonPosition.OUTSIDE);
        receiverModule=new ReceiverModule();
    }

    public void open()
    {
        isOpen=true;
    }

    public void close()
    {
        isOpen=false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public DoorButton getInsideDoorButton() {
        return insideDoorButton;
    }

    public DoorButton getOutsideDoorButton() {
        return outsideDoorButton;
    }
}

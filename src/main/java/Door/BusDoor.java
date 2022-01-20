package Door;

import CentralUnit.CentralUnit;

public class BusDoor {

    private boolean isOpen = false;
    private final DoorButton insideDoorButton;
    private final DoorButton outsideDoorButton;
    private final ReceiverModule receiverModule;
    private boolean isLocked = false;

    public BusDoor(CentralUnit centralUnit)
    {
        insideDoorButton=new DoorButton(DoorButtonPosition.INSIDE);
        outsideDoorButton=new DoorButton(DoorButtonPosition.OUTSIDE);
        receiverModule=new ReceiverModule(centralUnit);
    }

    public void open()
    {
        if(!isLocked)
        {
            isOpen=true;
        }
        else
        {
            System.out.println("Door is locked. Cant open it!");
        }

    }

    public void close()
    {
        if(!isLocked)
        {
            isOpen=false;
        }
        else
        {
            System.out.println("Door is locked. Cant close it!");
        }
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

    public ReceiverModule getReceiverModule() {
        return receiverModule;
    }


    public boolean getIsLocked(){return isLocked;}

    public void setIsLocked(boolean isLocked){this.isLocked=isLocked;}
}

package ID;

import Task_04_Strategy.IEncryption;

public class IDCard {

    private final RFIDChip rfidChip;

    public IDCard(int id, String firstName, String lastName, IEncryption encryption)
    {
        rfidChip = new RFIDChip(id, firstName, lastName, encryption);
    }

    public RFIDChip getRfidChip() {
        return rfidChip;
    }
}

package ID;

public class IDCard {

    private final RFIDChip rfidChip;

    public IDCard(int id,String firstName, String lastName)
    {
        rfidChip = new RFIDChip(id, firstName, lastName);
    }

    public RFIDChip getRfidChip() {
        return rfidChip;
    }
}

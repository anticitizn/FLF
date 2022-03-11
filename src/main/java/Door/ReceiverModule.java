package Door;

import CentralUnit.CentralUnit;

@SuppressWarnings({"ALL", "ClassCanBeRecord"})
public class ReceiverModule {

    private final CentralUnit centralUnit;

    public ReceiverModule(CentralUnit centralUnit) {
        this.centralUnit = centralUnit;
    }

    public void insertIDCard(byte[] encrypted)
    {
        centralUnit.setEncrypted(encrypted);
    }

    public void insertIDCard(String encrypted)
    {
        centralUnit.setEncrypted(encrypted);
    }
}

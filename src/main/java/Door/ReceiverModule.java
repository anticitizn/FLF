package Door;

import CentralUnit.CentralUnit;

public class ReceiverModule {

    private final CentralUnit centralUnit;

    public ReceiverModule(CentralUnit centralUnit) {
        this.centralUnit = centralUnit;
    }

    public void insertIDCard(byte[] encrypted)
    {
        centralUnit.setEncrypted(encrypted);
    }
}

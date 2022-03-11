package Configuration;

import Task_04_Strategy.AES;
import Task_04_Strategy.DES;
import Task_04_Strategy.RSA;

import java.io.FileInputStream;
import java.util.Properties;

public enum Configuration {
    instance;

    public final String userDirectory = System.getProperty("user.dir");
    public final String fileSeparator = System.getProperty("file.separator");
    public final String pathToJar = userDirectory + fileSeparator + fileSeparator + "jar" + fileSeparator + "mixingUnit.jar";

    public final AES encryptionAES = new AES();
    public final RSA encryptionRSA = new RSA(512);
    public final DES encryptionDES = new DES();
}
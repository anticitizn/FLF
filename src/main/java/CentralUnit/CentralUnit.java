package CentralUnit;

import Engine.Engine;
import Equipment.FloorSprayNozzle;
import Equipment.FrontLauncher;
import Equipment.RoofExtinguishingArm;
import Steering.SteeringAxis;
import Task_09_Visitor.IVisitor;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.util.ArrayList;

public class CentralUnit implements IVisitor {
    private final Engine engine;
    private final ArrayList<SteeringAxis> steeringAxes;
    private String encryptedString;
    private byte[] encrypted;
    private byte[] decrypted;
    private boolean isLocked;

    public CentralUnit(Engine engine, ArrayList<SteeringAxis> steeringAxes) {
        this.engine = engine;
        this.steeringAxes = steeringAxes;
    }

    public void switchOnEngine()
    {
        engine.switchOn();
    }

    public void switchOffEngine()
    {
        engine.switchOff();
    }

    public int getSpeed() {
        return engine.getSpeed();
    }

    public void gasPedalPressed() {
        engine.setSpeed(engine.getSpeed() + 4);
    }

    public void brakePedalPressed() {
        if (engine.getSpeed() > 4) {
            engine.setSpeed(engine.getSpeed() - 4);
        } else {
            engine.setSpeed(0);
        }
    }

    public void setRotation(int rotation) {
        for (SteeringAxis steeringAxis : steeringAxes) {
            steeringAxis.setRotation(rotation);
        }

    }

    public int getRotation() {
        return steeringAxes.get(0).getRotation();
    }

    public byte[] getEncryption()
    {
        return encrypted;
    }

    public void setEncrypted(byte[] encrypted) {
        this.encrypted = encrypted;
    }

    public void setEncrypted(String encrypted) {
        this.encryptedString = encrypted;
    }

    public void decrypt(byte[] textEncrypted,SecretKey secretKey, Cipher desCipher) {
        try {

            // Initialize the same cipher for decryption
            desCipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Decrypt the text
            byte[] textDecrypted = desCipher.doFinal(textEncrypted);
            decrypted = textDecrypted;
            System.out.println("Text Decrypted : " + new String(textDecrypted));


        } catch (
                InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
    }

    public void checkDecryptedString()
    {
        if(new String(decrypted).contains("6072")){
            isLocked= !isLocked;
        }
    }

    public boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean locked) {
        isLocked = locked;
    }

    @Override
    public void visit(FrontLauncher frontLauncher) {
        frontLauncher.shoot();
    }

    @Override
    public void visit(RoofExtinguishingArm roofExtinguishingArm) {
        roofExtinguishingArm.shoot();
    }

    @Override
    public void visit(FloorSprayNozzle floorSprayNozzle) {
        floorSprayNozzle.shoot();
    }
}

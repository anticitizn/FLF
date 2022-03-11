package ID;



import Task_04_Strategy.IEncryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

@SuppressWarnings("ALL")
public class RFIDChip {

    private final int id;
    private final String firstName;
    private final String lastName;
    private SecretKey myDesKey;
    private Cipher desCipher;
    private final IEncryption encryption;



    public RFIDChip(int id, String firstName, String lastName, IEncryption encryption) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.encryption=encryption;

    }

    public String doEncryption(String strToEncrypt){
        return encryption.doEncryption(strToEncrypt);
    }

    public SecretKey getMyDesKey()
    {
        try {

            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            this.myDesKey = keygenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return myDesKey;
    }

    public Cipher getDesCipher() {
        try {
            Cipher desCipher;

            //Create the cipher
            desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            this.desCipher=desCipher;
        } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return desCipher;
    }

    public byte[] encrypt(SecretKey secretKey, Cipher desCipher) {
        byte[] textEncrypted = new byte[0];

        try {

            //Initialize the cipher for encryption
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

            String nameString = firstName + " " + lastName;

            //sensitive information
            byte[] text = ("FT-DUS-FLF-" + id + "-" + nameString + "-6072").getBytes();

            //System.out.println("Text [Byte Format] : " + text);
            //System.out.println("Text : " + new String(text));

            // Encrypt the text
            textEncrypted = desCipher.doFinal(text);

            System.out.println("Text Encrypted : " + Arrays.toString(textEncrypted));

            return textEncrypted;

        } catch (
                InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }

        return textEncrypted;
    }


}







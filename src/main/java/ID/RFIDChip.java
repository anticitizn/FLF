package ID;



import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class RFIDChip {

    private int id;
    private String firstName;
    private String lastName;
    private SecretKey myDesKey;
    private Cipher desCipher;



    public RFIDChip(int id, String firstName, String lastName) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public SecretKey getMyDesKey()
    {
        try {

            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();
            this.myDesKey = myDesKey;
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
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
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

            System.out.println("Text Encryted : " + textEncrypted);

            return textEncrypted;

        } catch (
                InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }

        return textEncrypted;
    }


}







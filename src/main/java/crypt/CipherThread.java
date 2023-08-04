package crypt;

import crypt.cipherTypes.A1Z26Cipher;
import crypt.cipherTypes.AtbashCipher;
import crypt.cipherTypes.CeasarCipher;
import crypt.cipherTypes.Cipher;

public class CipherThread extends Thread {

    private final boolean isCrypted;
    private final String input;
    private Cipher cipher;
    private String output;

    public CipherThread(boolean isCrypted, String input, String cipher) {
        this.isCrypted = isCrypted;
        this.input = input;
        setCipher(cipher);
    }

    public void setCipher(String value) {
        switch (value) {
            case "Ceasar":
                this.cipher = new CeasarCipher(input);
                break;
            case "Atbash":
                this.cipher = new AtbashCipher(input);
                break;
            case "A1Z26":
                this.cipher = new A1Z26Cipher(input);
                break;
            default:
                this.cipher = new CeasarCipher(input);
                break;
        }

    }

    public Cipher getCipher() {
        return cipher;
    }

    public String processing() {
        if (isCrypted) output = cipher.decrypt();
        else output = cipher.decrypt();

        return output;
    }
}

package crypt;
import crypt.cipherTypes.Cipher;

public class Crypter {

    private final String input;
    private Cipher cipher;
    /**
     * Позволяет в рамках одного потока использовать несколько шифров
     * @param cipher тип шифра
     */
    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }
    public Cipher getCipher() {
        return cipher;
    }

    private String cryptedOutput;

    /**
     * осуществляет связь с client layer
     * @return зашированное сообщение
     */
    public String getCryptedOutput() {
        return cryptedOutput;
    }

    public Crypter(String input, Cipher cipher) {
        this.input = input;
        this.cipher = cipher;
    }

    public void setCryptedOutput() {
        cryptedOutput = cipher.crypt();
    }

}

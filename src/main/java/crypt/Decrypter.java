package crypt;

import crypt.cipherTypes.Cipher;

public class Decrypter {

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

    private String decryptedOutput;

    public Decrypter(String input, Cipher cipher) {
        this.input = input;
        this.cipher = cipher;
    }

    public void setDecryptedOutputyptedOutput() {
        decryptedOutput = cipher.decrypt();
    }

}

package crypt.cipherTypes;

public abstract class Cipher {

    private final String input;

    Cipher(String input) {
        this.input = input;
    }

    public abstract String crypt();

    public abstract String decrypt();

}
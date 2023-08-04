package crypt.cipherTypes;

public class AtbashCipher extends Cipher {
    private static String inputText;
    private static final char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public String getInputText() {
        return inputText;
    }

    public AtbashCipher(String inputText) {
        super(inputText);
        this.inputText = inputText;
    }


    @Override
    public String crypt() {
        StringBuilder sb = new StringBuilder();
        char[] charsText = inputText.toCharArray();
        for (int i = 0; i < inputText.length(); i++) {
            if (Character.isLetter(charsText[i])) {
                for (int j = 0; j < alphabet.length; j++) {
                    if (Character.isUpperCase(charsText[i])) charsText[i] = Character.toLowerCase(charsText[i]);
                    if (charsText[i] == alphabet[j]) {
                        sb.append(alphabet[alphabet.length - 1 - j]);
                    }
                }
            } else sb.append(charsText[i]);

        }
        return sb.toString();
    }

    @Override
    public String decrypt() {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            char currentChar = inputText.charAt(i);

            if (Character.isLetter(currentChar)) {
                char decryptedChar;
                if (Character.isUpperCase(currentChar)) {
                    decryptedChar = (char) ('Z' - (currentChar - 'A'));
                } else {
                    decryptedChar = (char) ('z' - (currentChar - 'a'));
                }
                decryptedText.append(decryptedChar);
            } else {
                decryptedText.append(currentChar);
            }
        }

        return decryptedText.toString();
    }
}

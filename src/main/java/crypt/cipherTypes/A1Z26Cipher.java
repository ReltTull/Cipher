package crypt.cipherTypes;

public class A1Z26Cipher extends Cipher {

    public static String inputText;

    public String getInputText() {
        return inputText;
    }

    private static final char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


    public A1Z26Cipher(String text) {
        super(text);
        this.inputText = text;
    }

    @Override
    public String crypt() {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            char ch = inputText.charAt(i);
            if (Character.isLetter(ch)) {
                // Определяем алфавитный индекс символа
                int alphabetIndex = Character.isUpperCase(ch) ? 'A' : 'a';
                int letterIndex = ch - alphabetIndex + 1;

                encryptedText.append(letterIndex);
            } else {
                // Если символ не является буквой, добавляем его без изменений
                encryptedText.append(ch);
            }

            // Добавляем разделитель между зашифрованными символами
            if (i < inputText.length() - 1) {
                encryptedText.append("-");
            }

        }
        return encryptedText.toString();
    }

    @Override
    public String decrypt() {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            char currentChar = inputText.charAt(i);

            if (Character.isDigit(currentChar)) {
                int number = Character.getNumericValue(currentChar);
                char decryptedChar = (char) ('A' + number - 1);
                decryptedText.append(decryptedChar);
            } else if (Character.isLetter(currentChar)) {
                int number = Character.toUpperCase(currentChar) - 'A' + 1;
                decryptedText.append(number);
            } else {
                decryptedText.append(currentChar);
            }
        }

        return decryptedText.toString();
    }

}

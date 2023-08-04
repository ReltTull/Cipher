package crypt.cipherTypes;

public class CeasarCipher extends Cipher {
    private static String inputText;
    private static int shift = 3;
    public CeasarCipher(String inputText) {
        super(inputText);
        CeasarCipher.inputText = inputText;
    }

    public String getInputText() {
        return inputText;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public static int getShift() {
        return shift;
    }
    @Override
    public String crypt() {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < inputText.length(); i++) {
            char ch = inputText.charAt(i);

            // Проверяем, является ли символ буквой
            if (Character.isLetter(ch)) {
                // Определяем смещение для шифровки
                int originalAlphabetPosition = Character.isUpperCase(ch) ? 'A' : 'a';
                int newAlphabetPosition = (ch - originalAlphabetPosition + getShift()) % 26;
                char encryptedChar = (char) (originalAlphabetPosition + newAlphabetPosition);

                encryptedText.append(encryptedChar);
            } else {
                // Если символ не является буквой, добавляем его без изменений
                encryptedText.append(ch);
            }
        }
        return encryptedText.toString();
    }

    @Override
    public String decrypt() {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            char ch = inputText.charAt(i);

            if (Character.isLetter(ch)) {
                int originalAlphabetPosition = Character.isUpperCase(ch) ? 'A' : 'a';
                // разница с processing() только в знаке getShift()
                int newAlphabetPosition = (ch - originalAlphabetPosition - getShift()) % 26;
                char decryptedChar = (char) (originalAlphabetPosition + newAlphabetPosition);

                decryptedText.append(decryptedChar);
            } else decryptedText.append(ch);
        }

        return decryptedText.toString();
    }

}

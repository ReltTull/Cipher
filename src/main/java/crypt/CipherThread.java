package crypt;

import crypt.cipherTypes.A1Z26Cipher;
import crypt.cipherTypes.AtbashCipher;
import crypt.cipherTypes.CeasarCipher;
import crypt.cipherTypes.Cipher;

import java.util.Scanner;


/**
 * Класс, создающий поток, когда пользователь предоставляет все данные.
 * Здесь, в зависимости от запроса, создаётся экз. абстрактоного класса Cipher, которому присваивается экз. одного из
 * классов по типам шифра. В методе processing() входящий текст обрабатывается методами cipher.crypt() или
 * cipher.decrypt(). Результат записывается в output.
 */
public class CipherThread extends Thread {

    /**
     * "переключатель" ширование/расшифровка. Если зашифровано - расщифровать. Если нет - зашифровать.
     */
    private final boolean isCrypted;

    private final Scanner scanner = new Scanner(System.in);
    /**
     * Входящий текст, получаемый через Scanner.
     */
    private final String input;
    private Cipher cipher;
    /**
     * Результат обработки. Идёт на вывод и может использоваться для записи в БД (с запросом идентификатора сообщения).
     */
    private String output;

    public CipherThread(boolean isCrypted) {
        this.isCrypted = isCrypted;
        System.out.print("Enter the massage: ");
        this.input = scanner.nextLine();
        System.out.print("Enter the cipher type: ");
        String cipher = scanner.nextLine();
        setCipher(cipher);
        scanner.close();
    }

    /**
     * Метод рекурсивно вызывается, пока не будет введён тип шифра.
     * @param value - тип шифра
     */
    public void setCipher(String value) {
        switch (value) {
            case "Ceasar" -> this.cipher = new CeasarCipher(input);
            case "Atbash" -> this.cipher = new AtbashCipher(input);
            case "A1Z26" -> this.cipher = new A1Z26Cipher(input);
            default -> {
                System.out.println("Type not found, enter cipher type: ");
                setCipher(scanner.nextLine());
            }
        }
        }

    public Cipher getCipher() {
        return cipher;
    }

    public String processing() {
        if (isCrypted) output = cipher.decrypt();
        else output = cipher.crypt();

        return output;
    }
}

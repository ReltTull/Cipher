package org.example;

import crypt.CipherThread;

import java.util.Random;

public class Application {
    public static void main(String[] args) {

//        for (int i = 0; i < 5; i++) {

            CipherThread cipherThread = new CipherThread(false, "Hey Duuude", "A1Z26");
            System.out.println(cipherThread.processing());
            System.out.println(cipherThread.getCipher().toString() + ", state - " + cipherThread.getState());
//        }
     }
}
package com.example.demo5;

public class Daluong implements Runnable {
    private final Encryptable algorithm;
    private final String data;

    public Daluong(Encryptable algorithm, String data) {
        this.algorithm = algorithm;
        this.data = data;
    }

    @Override
    public void run() {
        try {
            String encrypted = algorithm.encrypt(data);
            String decrypted = algorithm.decrypt(encrypted);

            System.out.println("Original: " + data);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


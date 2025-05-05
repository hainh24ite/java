package com.example.demo5;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    @FXML
    private TextField inputField;

    @FXML
    private ComboBox<String> algoBox;

    @FXML
    private TextArea outputArea;

    @FXML
    public void initialize() {
        algoBox.getItems().addAll("AES", "RSA");
        algoBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void handleEncryptDecrypt() {
        String text = inputField.getText();
        String algo = algoBox.getValue();

        try {
            Encryptable encryptable;
            if (algo.equals("AES")) {
                encryptable = new AESEncryption();
            } else {
                encryptable = new RSAEncryption();
            }

            Thread thread = new Thread(() -> {
                try {
                    // Mã hóa
                    String encrypted = encryptable.encrypt(text);

                    // Giải mã
                    String decrypted = encryptable.decrypt(encrypted);

                    // Kết quả
                    String result = "Original: " + text + "\n" +
                            "Encrypted: " + encrypted + "\n" +
                            "Decrypted: " + decrypted;

                    // Cập nhật giao diện từ thread chính
                    Platform.runLater(() -> outputArea.setText(result));

                } catch (Exception e) {
                    // Nếu có lỗi, in ra thông báo lỗi
                    Platform.runLater(() -> outputArea.setText("Lỗi: " + e.getMessage()));
                }
            });

            thread.start();

        } catch (Exception e) {
            e.printStackTrace();
            outputArea.setText("Lỗi: " + e.getMessage());
        }
    }
}

package com.thecoders.ekhdemli.java.controllers;

import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PasswordRecoveryController implements Initializable {
    @FXML
    private VBox root;
    @FXML // Scene (Step)
    private VBox paneSendMail, paneSended;
    @FXML // Email used to recover password
    private JFXTextField fieldEmail;

    private JFXSnackbar toastMsg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toastMsg = new JFXSnackbar(root);
    }

    @FXML
    private void onSend() {
        if(fieldEmail.getText() == null) {
            toastMsg.show("Email is Empty !", 1800);
            return;
        }
        if(!fieldEmail.getText().trim().toLowerCase().matches("^[a-z0-9_][a-z0-9_-]+@[a-z0-9_]{2,}\\.[a-z]{2,6}$")) {
            toastMsg.show("Invalid Email", 1800);
            return;
        }
        if(true) { // send mail and receive msg (mail sended)
            paneSendMail.setVisible(false);
            paneSended.setVisible(true);
        } else {
            toastMsg.show("Email Not Found !", 2000);
        }
    }

    @FXML
    private void onBackToSignIn() {
        VBox signInPane = null;
        try {
            signInPane = FXMLLoader.load(getClass().getResource("/com/thecoders/ekhdemli/resources/views/Login.fxml"));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        ((Stage) fieldEmail.getScene().getWindow()).setScene(new Scene(signInPane));
    }
}

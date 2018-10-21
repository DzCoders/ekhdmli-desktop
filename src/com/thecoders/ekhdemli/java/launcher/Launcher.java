package com.thecoders.ekhdemli.java.launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/thecoders/ekhdemli/resources/views/Login.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Ekhdemli App");
        stage.show();
    }
}

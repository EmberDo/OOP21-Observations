package org.observations;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.observations.controllers.MainWindowController;

public class Observations extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Observations");
        //initialize the controller and gets the main window node
        MainWindowController mainWindowController = new MainWindowController();
        Scene scene = new Scene((Parent) mainWindowController.getView(), 800, 600);
        mainWindowController.initializeChartsWindowController();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
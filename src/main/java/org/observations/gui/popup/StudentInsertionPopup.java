package org.observations.gui.popup;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.observations.controllers.StudentsViewController;

/**
 * Custom popup which create a window for the user to input a new student to the model to save.
 */
public class StudentInsertionPopup extends Stage {

    private static final String ALERT_MESSAGE = "Entrambi i campi devono essere riempiti.";
    private final StudentsViewController controller;

    public StudentInsertionPopup(StudentsViewController controller) {
        this.controller = controller;
        this.initOwner(controller.getView().getScene().getWindow());
        this.setWidth(250);
        this.setHeight(150);

        Label popupMessage = new Label("Inserisci nome e cognome studente");
        Button confirmButton = new Button("Inserisci studente");
        Button cancelButton = new Button("Cancella azione");
        TextField name = new TextField();
        TextField surname = new TextField();
        name.setPromptText("Inserisci nome");
        surname.setPromptText("Inserisci cognome");

        confirmButton.setOnAction(event -> {
            if (!surname.getText().isEmpty() && !name.getText().isEmpty()) {
                controller.updateModel(surname.getText() + " " + name.getText());
                name.clear();
                surname.clear();
                this.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, ALERT_MESSAGE);
                alert.show();
            }
        });

        cancelButton.setOnAction(event -> this.close());

        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(popupMessage, surname, name, new HBox(confirmButton, cancelButton));

        Scene scene = new Scene(box);
        this.setScene(scene);
    }
}

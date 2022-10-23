package org.observations.controllers;

import javafx.scene.Node;
import org.observations.gui.ObservationsView;
import org.observations.gui.View;

import java.util.List;
import java.util.Map;

public class ObservationsViewController implements SubController<String, Map<String, Map<String, Integer>>, List<String>> {

    private final MainWindowController parentController;
    private final View<Map<String, Map<String, Integer>>> view;
    private List<String> observationTypes;



    private Boolean updateAfterIncrement = false;


    public ObservationsViewController(MainWindowController mainWindowController, List<String> observationTypesList) {
        this.parentController = mainWindowController;
        this.observationTypes = observationTypesList;
        this.view = new ObservationsView(this);
    }

    public void updateView(Map<String, Map<String, Integer>> input) {
        System.out.println("\nOsservazioni: " + input);
        view.update(input);
    }

    public Node getView() {
        return view.getView();
    }

    public void setViewVisible(Boolean value) {
        view.setVisible(value);
    }

    public void getData(String text) {
    }

    public void updateModel(List<String> input) {
        this.parentController.incrementObservationCount(input.get(0), input.get(1));
    }

    public void updateObservationsCount(String date, String activity, Boolean isIncrement) {
        if(isIncrement){
            this.updateAfterIncrement = true;
            this.parentController.incrementObservationCount(date, activity);
        } else {
            this.parentController.decrementObservationCount(date, activity);
        }
    }

    public Boolean getUpdateAfterIncrement() {
        return updateAfterIncrement;
    }

    public void setUpdateAfterIncrement(Boolean updateAfterIncrement) {
        this.updateAfterIncrement = updateAfterIncrement;
    }

    public List<String> getObservationsTypesNames() {
        return this.observationTypes;
    }

    public void insertNewObservationType(String typeName){
        this.observationTypes = this.parentController.insertNewObservationType(typeName);
    }
}

package org.observations.controllers;

import javafx.scene.Node;

/**
 * Simple SubControlled interface for creating and controlling a View
 *
 * @param <M> Model data type required bi controller
 * @param <I> Type of input required by View
 * @param <O> Type of output required by Model
 */
public interface SubController<M, I, O> {

    /**
     * Updates the view with new data.
     *
     * @param input value to be inputted.
     */
    void updateView(I input);

    /**
     * Returns the controlled view root's node.
     *
     * @return node of view.
     */
    Node getView();

    /**
     * Set the view controlled on/off.
     *
     * @param value
     */
    void setViewVisible(Boolean value);

    /**
     * Ask data from the model.
     *
     * @param text Entry to be satisfied.
     */
    void getData(M text);

    /**
     * Handles new data to the model.
     *
     * @param output value to be outputted.
     */
    void updateModel(O output);
}

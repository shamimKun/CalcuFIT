/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 *
 * @author user
 */
public class InputNumberValidator implements ChangeListener<String> {

    TextField txt;

    public InputNumberValidator(TextField txt) {
        this.txt = txt;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        if (!newValue.matches("\\d*")) {
            txt.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
}

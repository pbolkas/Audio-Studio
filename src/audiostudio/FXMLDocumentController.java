/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostudio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.media.*;
import javafx.util.StringConverter;

/**
 * @author Παύλος
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ToggleGroup group = new ToggleGroup();
    @FXML
    private Label bassLabel;
    @FXML
    private Label midrangeLabel;
    @FXML
    private Label trembleLabel;
    @FXML
    private Label balanceLabel;
    @FXML
    private Label volumeLabel;
    @FXML
    private Slider bass;
    @FXML
    private Slider midrange;
    @FXML
    private Slider tremble;
    @FXML
    private Slider balance;
    @FXML
    private Slider volume;
    @FXML
    private RadioButton m0;
    @FXML
    private RadioButton m1;
    @FXML
    private RadioButton m2;

    @FXML
    private Button store;

    @FXML
    private Label showBass;
    @FXML
    private Label showMidrange;
    @FXML
    private Label showTremble;
    @FXML
    private Label showBalance;
    @FXML
    private Label showVolume;

    @FXML
    private StringConverter<Double> tickString = new StringConverter<Double>() {
        @Override
        public String toString(Double n) {
            if (n == 5) {
                return "R";
            }
            if (n == -5) {
                return "L";
            }
            if (n == 0) {
                return "C";
            }
            return "";
        }

        @Override
        public Double fromString(String s) {
            switch (s) {
                case "L":
                    return 0d;
                case "R":
                    return 1d;
                default:
                    return 2d;
            }
        }
    };

    Presets[] presets = new Presets[3];
    Presets Default;
    Presets Preset1;
    Presets Preset2;

    public void setupPresets() {
        Default = presets[0] = new Presets(0, 0, 0, 0, 0);
        Preset1 = presets[1] = new Presets(1, -1, 9, 0, 4);
        Preset2 = presets[2] = new Presets(2, 4, -2, 4, 2);
    }

    @FXML
    private GridPane grid = new GridPane();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.balance.setLabelFormatter(this.tickString);
        this.m0.setToggleGroup(this.group);
        this.m1.setToggleGroup(this.group);
        this.m2.setToggleGroup(this.group);
        this.m0.setSelected(true);
        setupPresets();
        updateLabels();
        addListenerToGroup();
        this.store.setOnAction((event) -> {
            storePresets();
        });
    }

    private void updateLabels() {
        bass.valueProperty().addListener((observable, oldValue, newValue) -> {
            showBass.setText("Bass : " + String.format("%.0f", newValue));

        });

        midrange.valueProperty().addListener((observable, oldValue, newValue) -> {
            showMidrange.setText("Midrange : " + String.format("%.0f", newValue));
        });

        tremble.valueProperty().addListener((observable, oldValue, newValue) -> {
            showTremble.setText("Tremble : " + String.format("%.0f", newValue));
        });

        balance.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() > 0) {
                showBalance.setText("Balance : R");
            } else if (newValue.intValue() == 0) {
                showBalance.setText("Balance : N");
            } else {
                showBalance.setText("Balance : L");
            }
        });

        volume.valueProperty().addListener((observable, oldValue, newValue) -> {
            showVolume.setText("Volume : " + String.format("%.0f", newValue));
        });
    }

    private void addListenerToGroup() {
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                    Toggle old_toggle, Toggle new_toggle) {
                if (group.getSelectedToggle() != null) {
                    checkSelection(new Presets[]{Default, Preset1, Preset2});
                }
            }
        });
    }

    private void storePresets() {
        if (group.getSelectedToggle() != null) {
            if (m0.isSelected()) {
                Default = new Presets((int) (bass.getValue()),
                        (int) (midrange.getValue()),
                        (int) (tremble.getValue()),
                        (int) (balance.getValue()),
                        (int) (volume.getValue()));
            } else if (m1.isSelected()) {
                Preset1 = new Presets((int) (bass.getValue()),
                        (int) (midrange.getValue()),
                        (int) (tremble.getValue()),
                        (int) (balance.getValue()),
                        (int) (volume.getValue()));
            } else if (m2.isSelected()) {
                Preset2 = new Presets((int) (bass.getValue()),
                        (int) (midrange.getValue()),
                        (int) (tremble.getValue()),
                        (int) (balance.getValue()),
                        (int) (volume.getValue()));
            }
        }
    }

    private void checkSelection(Presets pin[]) {
        if (m0.isSelected()) {
            bass.setValue(pin[0].bass);
            midrange.setValue(pin[0].midrange);
            tremble.setValue(pin[0].treble);
            balance.setValue(pin[0].balance);
            volume.setValue(pin[0].volume);
        } else if (m1.isSelected()) {

            bass.setValue(pin[1].bass);
            midrange.setValue(pin[1].midrange);
            tremble.setValue(pin[1].treble);
            balance.setValue(pin[1].balance);
            volume.setValue(pin[1].volume);

        } else if (m2.isSelected()) {
            bass.setValue(pin[2].bass);
            midrange.setValue(pin[2].midrange);
            tremble.setValue(pin[2].treble);
            balance.setValue(pin[2].balance);
            volume.setValue(pin[2].volume);
        }
    }
}

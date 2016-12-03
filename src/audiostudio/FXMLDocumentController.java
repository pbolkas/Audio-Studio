/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostudio;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;

import com.sun.deploy.panel.RadioPropertyGroup;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
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
            if (n == 5) return "R";
            if (n == -5) return "L";
            if (n == 0) return "C";
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

    class Presets {

        int bass;
        int midrange;
        int treble;
        int balance;
        int volume;

        Presets(int b, int m, int t, int ba, int v) {
            bass = b;
            midrange = m;
            treble = t;
            balance = ba;
            volume = v;
        }
    }

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
    }
}

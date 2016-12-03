/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiostudio;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.deploy.panel.RadioPropertyGroup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

/**
 *
 * @author Παύλος
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private RadioButton m0;
    @FXML
    private RadioButton m1;
    @FXML
    private RadioButton m2;
    @FXML
    private final ToggleGroup group=new ToggleGroup();
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
    private StringConverter<Double> tickString=new StringConverter<Double>() {
        @Override
        public String toString(Double n) {
            if(n>4) return "R";
            if(n<-4) return "L";
            if(n==0) return "C";
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





    @FXML
    private GridPane grid=new GridPane();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.balance.setLabelFormatter(this.tickString);
        this.m0.setToggleGroup(this.group);
        this.m1.setToggleGroup(this.group);
        this.m2.setToggleGroup(this.group);
        this.m0.setSelected(true);

    }    
    
}

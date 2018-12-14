package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Eddit_controller {

    @FXML
    private TextField FullNameId;

    @FXML
    private TextField flightNumberID;

    @FXML
    private TextField luggageReceiptNumberID;

    @FXML
    private TextField numberOfPiecesOfBaggageID;

    @FXML
    private TextField totalBaggageWeightID;

    @FXML
    private Button AddButtonID;

    @FXML
    private Label Error;

    @FXML
    private Label Error2;

   // @FXML
   // private ChoiceBox<String>  ChoiseID = new ChoiceBox<String>(Choise);

    @FXML
    void EdditPerson(ActionEvent actionEvent) {
        for(int i = 0; i < AirportArrayList.airports.size();i++){
            ObservableList<String> Choise = FXCollections.observableArrayList(AirportArrayList.airports.get(i).getFullName(),
                    AirportArrayList.airports.get(i++).getFullName());
            ChoiceBox<String> ChoiseID = new ChoiceBox<String>(Choise);


        }

    }

}

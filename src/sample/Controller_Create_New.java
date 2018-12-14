package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller_Create_New {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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

    @FXML
    void initialize() {
        assert FullNameId != null : "fx:id=\"FullNameId\" was not injected: check your FXML file 'CreateNewPassager.fxml'.";
        assert flightNumberID != null : "fx:id=\"flightNumberID\" was not injected: check your FXML file 'CreateNewPassager.fxml'.";
        assert luggageReceiptNumberID != null : "fx:id=\"luggageReceiptNumberID\" was not injected: check your FXML file 'CreateNewPassager.fxml'.";
        assert numberOfPiecesOfBaggageID != null : "fx:id=\"numberOfPiecesOfBaggageID\" was not injected: check your FXML file 'CreateNewPassager.fxml'.";
        assert totalBaggageWeightID != null : "fx:id=\"totalBaggageWeightID\" was not injected: check your FXML file 'CreateNewPassager.fxml'.";
        assert AddButtonID != null : "fx:id=\"AddButtonID\" was not injected: check your FXML file 'CreateNewPassager.fxml'.";
        assert Error != null : "fx:id=\"Error\" was not injected: check your FXML file 'CreateNewPassager.fxml'.";
        assert Error2 != null : "fx:id=\"Error2\" was not injected: check your FXML file 'CreateNewPassager.fxml'.";

    }

    public void createNewPerson(ActionEvent actionEvent){
        if(isDigit(numberOfPiecesOfBaggageID.getText()) && isDigit(totalBaggageWeightID.getText())){
            int numberOfPiecesOfBaggageInt = Integer.parseInt(numberOfPiecesOfBaggageID.getText());
            int totalBaggageWeightInt = Integer.parseInt(totalBaggageWeightID.getText());
            Airport airport1 = new Airport (FullNameId.getText(), flightNumberID.getText(),luggageReceiptNumberID.getText(),numberOfPiecesOfBaggageInt,totalBaggageWeightInt);
            AirportArrayList.airports.add(airport1);
            Error.setText("");
            Error2.setText("");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Результат");
            alert.setHeaderText("Пассажир добавлен в список");
            alert.showAndWait();
        }
        else
        {
            if (!(isDigit(numberOfPiecesOfBaggageID.getText()))){ Error.setText("ERROR");
            numberOfPiecesOfBaggageID.clear();
            }
            else {
                Error2.setText("ERROR");
                totalBaggageWeightID.clear();
            }

        }
        /*int numberOfPiecesOfBaggageInt = Integer.parseInt(numberOfPiecesOfBaggageID.getText());
        int totalBaggageWeightInt = Integer.parseInt(totalBaggageWeightID.getText());
        Airport airport1 = new Airport (FullNameId.getText(), flightNumberID.getText(),luggageReceiptNumberID.getText(),numberOfPiecesOfBaggageInt,totalBaggageWeightInt);
        AirportArrayList.airports.add(airport1);*/

    }
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

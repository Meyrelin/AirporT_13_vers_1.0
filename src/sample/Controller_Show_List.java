package sample;



import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller_Show_List {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ErrorPass;

    @FXML
    private TableView<Airport> Table_List;

    @FXML
    private TableColumn<Airport, String> Full_Name;

    @FXML
    private TableColumn<Airport, String> Flight_Number;

    @FXML
    private TableColumn<Airport, String> Luggage_Receipt_Number;

    @FXML
    private TableColumn<Airport, Integer> Number_Of_Pieces_Of_Baggage;

    @FXML
    private TableColumn<Airport, Integer> Total_Baggage_Weight;

    @FXML
    void initialize() {
        Full_Name.setCellValueFactory((new PropertyValueFactory<>("fullName")));
        Flight_Number.setCellValueFactory((new PropertyValueFactory<>("flightNumber")));
        Luggage_Receipt_Number.setCellValueFactory((new PropertyValueFactory<>("luggageReceiptNumber")));
        Number_Of_Pieces_Of_Baggage.setCellValueFactory((new PropertyValueFactory<>("numberOfPiecesOfBaggage")));
        Total_Baggage_Weight.setCellValueFactory((new PropertyValueFactory<>("totalBaggageWeight")));
        Table_List.setItems(AirportArrayList.airports);

    }



}


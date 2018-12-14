package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;


public class Controller {

    @FXML
    private TextField PasswordButton;

    @FXML
    private Button InButtonAdmin;

    @FXML
    private Label ErrorPass;

    /*Menu*/
    @FXML
    private Button OutButtonAdmin;

    @FXML
    private Button LisrArray;

    @FXML
    private Button SearchPasseng;

    @FXML
    private Button EditPasseng;

    @FXML
    private Button DeletePasseng;

    @FXML
    private Button AddPasseng;


    public void PassWord(ActionEvent event) throws Exception {
        if (PasswordButton.getText().equals("666")) {
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            AirportArrayList.test();

            appStage.show();


        } else {
            ErrorPass.setText("ERROR");
            PasswordButton.clear();
        }
    }


    public void PassngeListShow(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Show_menu_list.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Airport_13");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // primaryStage.setResizable(false);//отключаем изменение размера сцены
        primaryStage.show();


    }

    public void searchOnClick(ActionEvent actionEvent) {

        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Поиск");
        //Создаем диалоговое окно
        GridPane grid = new GridPane();
        grid.setHgap(10);/**/
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 10, 10, 10));
        // Set the button types.
        ButtonType searchButtonType = new ButtonType("Найти", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(searchButtonType, ButtonType.CANCEL);
        //проверяем состояние поля ввода
        //пока оно пустое, кнопка будет оставаться неактивной

        Label label = new Label("Ввведите искомый рейс: ");
        grid.add(label, 0, 0);
        TextField textField = new TextField();
        grid.add(textField, 1, 0);
        dialog.setResultConverter(dialogButton -> {
            String tmpArray = "";
                    for (int i = 0; i < AirportArrayList.airports.size(); i++) {
                        if (AirportArrayList.airports.get(i).getFlightNumber().equals(textField.getText())) {
                            tmpArray += AirportArrayList.airports.get(i).getFullName() + "\n";
                        }
                    }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Результат");
            alert.setHeaderText(tmpArray);
            alert.showAndWait();
            return null;
        });
        dialog.getDialogPane().setContent(grid);
        dialog.showAndWait();
    }
    public void deletePassagerInfo(ActionEvent actionEvent)
    {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Удаление пользователя по фамилии");
        //Создаем диалоговое окно
        GridPane grid = new GridPane();
        grid.setHgap(10);/**/
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 10, 10, 10));
        // Set the button types.
        ButtonType searchButtonType = new ButtonType("Удалить", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(searchButtonType, ButtonType.CANCEL);


        Label label = new Label("Введите фамилию пассажира: ");
        grid.add(label, 0, 0);
        TextField textField = new TextField();
        grid.add(textField, 1, 0);
        dialog.setResultConverter(dialogButton -> {
            String tmpArray = "";

            for (int i = 0; i < AirportArrayList.airports.size(); i++)
            {
      //          for(int j = 0; j < AirportArrayList.airports.size(); j++)
                if (AirportArrayList.airports.get(i).getFullName().equals(textField.getText()))
                {
                    AirportArrayList.airports.remove(i);
i--;
                 }
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Результат");
            alert.setHeaderText("Пассажир удален из списка");
            alert.showAndWait();
            return null;
        });
        dialog.getDialogPane().setContent(grid);
        dialog.showAndWait();
    }
    public void createNewPassenger(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CreateNewPassager.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Airport_13");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // primaryStage.setResizable(false);//отключаем изменение размера сцены
        primaryStage.show();
    }
    public void edditOldPassager(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("EdditPassager.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Airport_13");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // primaryStage.setResizable(false);//отключаем изменение размера сцены
        primaryStage.show();
    }
    public  void Exit(ActionEvent actionEvent){
        System.exit(0);
    }
}



/*
   0. showArrayList - вывод всего списка

   1. DeleteByName - удаление записей о пассажирах с заданной фамилией;

*  2. LuggageWeightPerPassenger - выдать сведения о пассажире, чей багаж больше 30 кг;
*
*  3. TotalBaggageAmount - выдать сведения о суммарном весе багажа всех пассажиров РЕЙСА;
*
*  4. LuggageLocation - сведения о местонахождении багажа(номер рейса) по заданному номеру
*  багажной квитанции (LuggageReceiptNumber);
  */
package  sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.lang.String;

public class AirportArrayList implements Serializable {
   public static ObservableList<Airport> airports= FXCollections.observableArrayList();

    public void addNewAirportItem(Airport airportArrayList) {
        this.airports.add(airportArrayList);
    }
   public void addNewAirportItem(ArrayList<Airport> airportArrayList) {
        this.airports.addAll(airportArrayList);
    }
  public void Save (String f1){
      try{
          FileOutputStream outputFile = new FileOutputStream(f1);
          ObjectOutputStream outputObject = new ObjectOutputStream(outputFile);

          outputObject.writeObject((ArrayList<Airport>)airports);
          outputObject.flush();
          outputObject.close();
          outputFile.flush();
          outputFile.close();
          System.out.println("Данные записаны в файл " + f1);
      }
      catch (IOException exception){
          System.out.println("Ошибка работы с файлом или потоком");
          exception.printStackTrace();
      }
  }

  public static void test(){
      Airport airport1 = new Airport ("Ivan Ivanov", "A123","SQ-77",1,20 );

      Airport airport2 = new Airport ("Alex Toms", "KM45","AC-66",2,25 );

      Airport airport3 = new Airport ("Ivan Shevchenko", "SL98","DC-55",3,30 );

      Airport airport4 = new Airport ("Mila Kosa", "D56","KL-44",4,35 );

      Airport airport5 = new Airport ("Ivan Gleb", "A123","XX-33",5,40);
        airports.addAll(airport1,airport2,airport3,airport4,airport5);
    }

    public void Load (String file){
        try{
            FileInputStream inputFile = new FileInputStream(file);
            ObjectInputStream inputObject = new ObjectInputStream(inputFile);
            ArrayList<Airport> temp=new ArrayList<>();
           temp = (ArrayList<Airport>) inputObject.readObject();
            inputFile.close();
            inputObject.close();
            this.airports=FXCollections.observableArrayList(temp);
            System.out.println("Данные успешно загружены из файла " + file);
        }
        catch (IOException exception){
            System.out.println("Ошибка загрузки из файла.");
            return;
        }
        catch (ClassNotFoundException exception){
            System.out.println("Класс не найден");
            exception.printStackTrace();
        }
    }

    public void deleteAll() {
        this.airports.clear();
    }

    public void  showArrayList() {
        for (Airport airportArrayList : airports) {
            System.out.println(airportArrayList);
            System.out.println("----------------------------");
        }
    }



    public void LuggageWeightPerPassenger()
    { int baggage = 30;
        for (int i = 0; i < airports.size(); i++)
        {
            if (airports.get(i).getTotalBaggageWeight() >= baggage)
            {
                System.out.println("Baggage > 30 kg: " + airports.get(i).getFullName() + "    "+ airports.get(i).getFlightNumber()+ "    "+ airports.get(i).getLuggageReceiptNumber()+ "    " + airports.get(i).getNumberOfPiecesOfBaggage());
                System.out.println("----------------------------");
            }
        }


    }


    public void TotalBaggageAmount( String  FlightNumber)
    {
        int totalAmount =0;

        for (int i=0 ; i < airports.size(); i++)
        {
            if(airports.get(i).getFlightNumber()== "A123")
            {
                totalAmount += airports.get(i).getTotalBaggageWeight();
            }
        }
        System.out.println("Total weight of baggage on flight : " + totalAmount + " kg "+ " => Flight : " + FlightNumber);/* -???- */
        System.out.println("----------------------------");

    }


    public void LuggageLocation(String LuggageReceiptNumber)
    {    for (int i=0 ; i < airports.size(); i++){
        if(airports.get(i).getLuggageReceiptNumber().equalsIgnoreCase(LuggageReceiptNumber))
        {System.out.println("Baggage : " + airports.get(i).getLuggageReceiptNumber() + " => Flight : " +airports.get(i).getFlightNumber());
            System.out.println("----------------------------");
        }
    }

    }




    public void deleteDeleteByName() {
        this.airports.remove(1);
        System.out.println(airports);
        System.out.println("----------------------------"); }/* задать index от 0 до 4, чтобы удалить пассажира */

}




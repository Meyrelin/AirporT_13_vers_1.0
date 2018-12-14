package  sample;
import java.io.Serializable;

public class Airport  implements Serializable {
    private String fullName;/*Фамилия имя*/
    private String flightNumber;/*номер рейса*/
    private String luggageReceiptNumber;/*номер багажной квитанции*/
    private int numberOfPiecesOfBaggage;/*кол-во мест багажа*/
    private int totalBaggageWeight;/*суммарный вес багажа пассажира*/


    enum flightNumber {
        A123,
        KM45,
        SL98,
        D56
    }

    Airport(){
        fullName = "DefaultFullName";
        flightNumber = "DefaultFlight";
        luggageReceiptNumber = "DefaultLuggageReceiptNumber";
        numberOfPiecesOfBaggage = 0;
        totalBaggageWeight = 0;
    }
    Airport(String FullName, String FlightNumber,String LuggageReceiptNumber,int NumberOfPiecesOfBaggage,int TotalBaggageWeight ){
        this.fullName = FullName;
        this.flightNumber = FlightNumber;
        this.luggageReceiptNumber = LuggageReceiptNumber;
        this.numberOfPiecesOfBaggage = NumberOfPiecesOfBaggage;
        this.totalBaggageWeight = TotalBaggageWeight;
    }



    public String getFullName(){
        return fullName;
    }
    public void setFullName(){
        this.fullName = fullName;
    }



    public String getFlightNumber(){
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber){
        this.flightNumber ="DefautFlight";

      /*  for(flightNumber variants: flightNumber.){
            if(FlightNumber.equalsIgnoreCase(variants.toString()))
                this.flightNumber = variants.toString();*
        }*/
    }



    public String getLuggageReceiptNumber(){
        return luggageReceiptNumber;
    }

    public void setLuggageReceiptNumber(){
        this.luggageReceiptNumber = luggageReceiptNumber;
    }



    public int getNumberOfPiecesOfBaggage(){
        return numberOfPiecesOfBaggage;
    }

    public void setNumberOfPiecesOfBaggage(){
        if(numberOfPiecesOfBaggage >=0) {
            this.numberOfPiecesOfBaggage = numberOfPiecesOfBaggage;
        }
        else {
            System.out.println(" ! ERROR !");
        }

    }



    public int getTotalBaggageWeight(){
        return totalBaggageWeight;
    }

    public void setTotalBaggageWeight(){
        if(totalBaggageWeight >= 0) {
            this.totalBaggageWeight = totalBaggageWeight;
        }
        else {
            System.out.println(" ! ERROR !");
        }
    }

    @Override
    public String toString() {
        return "Airport[ " +
                " " + fullName +
                ", " + flightNumber +
                ", " + luggageReceiptNumber +
                ", " + numberOfPiecesOfBaggage +
                ", " + totalBaggageWeight + "kg"+
                " ]";
    }
}


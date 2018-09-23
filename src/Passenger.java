import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Passenger {

    private enum fields{
        FIO,
        Birthday,
        Gender,
        DepartureDate,
        Ticket,
        Train,
        Car,
        Place,
        Type,
        Cost,
        DepartureTown,
        ArrivingTown
    }
    private SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
    private ArrayList<String> dataFromString = new ArrayList<>();

    Passenger(String inpFromCSV) {
        Scanner sc = new Scanner(inpFromCSV).useDelimiter(",");
        while(sc.hasNext())
            dataFromString.add(sc.next());
    }
    public void Display() {
        for(fields f : fields.values())
            System.out.println(dataFromString.get(f.ordinal()));
    }

    public String getFIO() {
        return  dataFromString.get(fields.FIO.ordinal());
    }
    public Date getBirthday() {

        try {
            return ft.parse(dataFromString.get(fields.Birthday.ordinal()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }
    public String getGender() {
        return  dataFromString.get(fields.Gender.ordinal());
    }
    public Date getDepartureDate() {
        try {
            return ft.parse(dataFromString.get(fields.DepartureDate.ordinal()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }
    public String getTicket() {
        return  dataFromString.get(fields.Ticket.ordinal());
    }
    public Integer getTrain() {
        return Integer.valueOf(dataFromString.get(fields.Train.ordinal()));
    }
    public Integer getCar() {
        return Integer.valueOf(dataFromString.get(fields.Car.ordinal()));
    }
    public Integer getPlace() {
        return Integer.valueOf(dataFromString.get(fields.Place.ordinal()));
    }
    public type getType() {
        return dataFromString.get(fields.Type.ordinal()).equals("1") ? type.kupe : type.plac;
    }
    public Double getCost() {
        return Double.valueOf(dataFromString.get(fields.Cost.ordinal()));
    }
    public String getDepartureTown() {
        return  dataFromString.get(fields.DepartureTown.ordinal());
    }
    public String getArrivingTown() {
        return  dataFromString.get(fields.ArrivingTown.ordinal());
    }

    public Integer getAge(){
        return Math.toIntExact((
                (new Date().getTime() - getBirthday().getTime())
                        / (24 * 60 * 60 * 1000) / 365));
    }
}

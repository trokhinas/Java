import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Passenger {

    enum fields{
        FIO,
        Birthday,
        Male,
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
    ArrayList<String> dataFromString = new ArrayList<>();

    Passenger(String inpFromCSV)
    {
        int begin = 0, end = inpFromCSV.indexOf(',');
        while(end != -1)
        {
            dataFromString.add(inpFromCSV.substring(begin, end));

            inpFromCSV = inpFromCSV.substring(end + 1);
            end = inpFromCSV.indexOf(',');
        }
        end = inpFromCSV.length();
        dataFromString.add(inpFromCSV.substring(begin, end));
    }
    void Display()
    {
        for(fields f : fields.values())
            System.out.println(dataFromString.get(f.ordinal()));
    }

    String getFIO() {
        return  dataFromString.get(fields.FIO.ordinal());
    }
    Date getBirthday() {
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return ft.parse(dataFromString.get(fields.Birthday.ordinal()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }



}

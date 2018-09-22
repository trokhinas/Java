import java.util.Date;

public class MaIN {

    public static void main(String[] args) {
        Passenger a = new Passenger("Иванов Иван Петрович,01.01.1972,М,22.09.2018,Б20180922-156-" +
                "678,25,4,22,1,3267.8,Москва,Воронеж");
        a.Display();
        /*System.out.println((new Date().getTime() - dt.getTime())/ (24 * 60 * 60 * 1000)/365);
         пример вычисления возраста
        System.out.println();
        System.out.println(a.getFIO());
        System.out.println(a.getBirthday());
        System.out.println(a.getGender());
        System.out.println(a.getDepartureDate());
        System.out.println(a.getTicket());
        System.out.println(a.getTrain());
        System.out.println(a.getCar());
        System.out.println(a.getPlace());
        System.out.println(a.getType());
        System.out.println(a.getCost());
        System.out.println(a.getDepartureTown());
        System.out.println(a.getArrivingTown());*/
        PassengerHandler customersHandler = new PassengerHandler();
        customersHandler.read(a);
        a = new Passenger("Петрова Мария Семеновна,02.12.1985,Ж,23.09.2018,Б20180922-157-" +
                "699,25,5,23,1,3267.8,Москва,Воронеж");
        customersHandler.read(a);
        a = new Passenger("Рогачев Семен Петрович,11.01.1972,М,27.09.2018,Б20180922-166-\n" +
                "678,25,14,12,2,2447.4,Воронеж,Москва");
        customersHandler.read(a);
        a = new Passenger("Петренко Дарья Антоновна,14.08.1989,Ж,28.09.2018,Б20180922-167-\n" +
                "699,25,12,13,2,2447.4,Воронеж,Москва");
        customersHandler.read(a);
        a = new Passenger("Тюнин Роман Викторович,12.11.1984,М,27.09.2018,Б20180922-203-\n" +
                "678,25,14,24,2,2447.4,Воронеж,Москва");
        customersHandler.read(a);
        customersHandler.printTable();
    }
}

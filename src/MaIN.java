import java.util.Date;

public class MaIN {

    public static void main(String[] args) {
        Passenger a = new Passenger("Иванов Иван Петрович,01.01.1972,М,22.09.2018,Б20180922-156-" +
                "678,25,4,22,1,3267.8,Москва,Воронеж");
        a.Display();
        PassengerHandler customersHandler = new PassengerHandler();
        customersHandler.read(a);
        a = new Passenger("Петрова Мария Семеновна,02.12.1985,Ж,23.09.2018,Б20180922-157-" +
                "699,25,5,23,1,3267.8,Москва,Воронеж");
        customersHandler.read(a);
        a = new Passenger("Рогачев Семен Петрович,11.01.1972,М,27.09.2018,Б20180922-166-" +
                "678,25,14,12,2,2447.4,Воронеж,Москва");
        customersHandler.read(a);
        a = new Passenger("Петренко Дарья Антоновна,14.08.1989,Ж,28.09.2018,Б20180922-167-" +
                "699,25,12,13,2,2447.4,Воронеж,Москва");
        customersHandler.read(a);
        a = new Passenger("Тюнин Роман Викторович,12.11.1984,М,27.09.2018,Б20180922-203-" +
                "678,25,14,24,2,2447.4,Воронеж,Москва");
        customersHandler.read(a);
        customersHandler.printTable();

        PassengerHandler ph = new PassengerHandler("D:\\test\\inp.txt");
        ph.printTable("D:\\test\\out.txt");
    }
}

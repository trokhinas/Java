import java.util.Date;

public class MaIN {

    public static void main(String[] args) {
        Passenger a = new Passenger("Иванов Иван Петрович,01.01.1972,М,22.09.2018,Б20180922-156-" +
                "678,25,4,22,1,3267.8,Москва,Воронеж");
        a.Display();
        System.out.println();
        System.out.println(a.getFIO());
        System.out.println(a.getBirthday());
        Date dt = a.getBirthday();
        System.out.println((new Date().getTime() - dt.getTime())/ (24 * 60 * 60 * 1000)/365);//пример вычисления возраста
    }
}

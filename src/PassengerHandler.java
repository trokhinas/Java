import javafx.util.Pair;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class PassengerHandler {


    /**
     * хранение данных о пассажирах, на случай, если придется их как - то еще обрабатывать
     */
    private ArrayList<Passenger> dataFromCSV;
    /**
     * //таблица хранящая пару(пол, возраст) в качестве ключа
     * и пару(число, число) в качестве значения, где числа обозначают количество билетов конкретного типа(купе или плацкарт)
     */
    private SortedMap<Pair<String, Integer>, Pair<Integer, Integer>> personTrainMap;

    /**
     * конструктор просто инициализирует нужные нам коллекции,
     */
    PassengerHandler() {
        dataFromCSV = new ArrayList<>();
        personTrainMap = new TreeMap<>(Comparator.comparingInt(Pair::getValue));
        //здесь я использовал конструктор с передачей компаратора
        //так как Pair не реализует интерфейс Comparable
    }
    PassengerHandler(String source){
        dataFromCSV = new ArrayList<>();
        personTrainMap = new TreeMap<>(Comparator.comparingInt(Pair::getValue));

        try {
            FileReader fr = new FileReader(source);

            /**
             * тут очень спорный вопрос, но так как я читал из файла txt, то я использовал такую кодировку
             * возможно у этой проблемы есть более элегантное решение
             */
            Scanner sc = new Scanner(Paths.get(source), "Cp1251");
            while(sc.hasNextLine()) {
                String s = sc.nextLine();
                read(new Passenger(s));
                System.out.println(s);
            }

            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Эта функция производит считывание информации о конкретном пассажире,заполняя коллекции
     * @param p - обрабатываемый пассажир
     */
    public void read(Passenger p) {
        if(p == null)
            return;
        dataFromCSV.add(p);

        Pair<String, Integer> key = new Pair<>(p.getGender(), p.getAge());
        Pair<Integer, Integer> value = new Pair<>(0, 0);
        if(personTrainMap.containsKey(key)) {
            value = personTrainMap.get(key);
        }
        if (p.getType() == type.kupe)
            value = new Pair<>(value.getKey() + 1, value.getValue());
        else
            value = new Pair<>(value.getKey(), value.getValue() + 1);
        personTrainMap.put(key,value);
    }

    /**
     * построение таблицы, по имеющимся данным
     */
    public void printTable() {
        System.out.println(",,1,2\n");
        for(Pair<String, Integer> person : personTrainMap.keySet())
            System.out.print(makeString(person));
    }
    public void printTable(String path){

        try {
            FileWriter fOut = new FileWriter(path);

            fOut.write(",,1,2\n");
            for(Pair<String, Integer> person : personTrainMap.keySet()) {
                fOut.write(makeString(person));
            }
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(1);
        }

    }

    private String makeString(Pair<String, Integer> person){
        StringBuilder sb = new StringBuilder();
        sb.append(person.getKey())
                .append(',')
                .append(person.getValue())
                .append(',')
                .append(personTrainMap.get(person).getKey())
                .append(',')
                .append(personTrainMap.get(person).getValue())
                .append('\n');
        return String.valueOf(sb);
    }
}

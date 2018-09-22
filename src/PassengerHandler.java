import javafx.util.Pair;

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
        StringBuilder sb = new StringBuilder();
        System.out.println(",,1,2");

        //эту операцию можно вынести в отдельную функцию,
        //которая строит строку для конкретного person из таблицы, где person всего лишь комбинация (пол, возраст)
        for(Pair<String, Integer> person : personTrainMap.keySet())
            System.out.println(person.getKey() + ','
                    + person.getValue() + ','
                    + personTrainMap.get(person).getKey() + ','
                    + personTrainMap.get(person).getValue());
    }
}

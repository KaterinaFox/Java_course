//Задача 2. Пусть дан список сотрудников:
    // а) Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // б) Отсортировать по убыванию популярности Имени.
import java.util.*;

public class Task005_02 {
        public static void main(String[] args) {
        String[] firstNameSurName = {
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"
        };
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String s : firstNameSurName) {
            String[] splited = s.split(" ");
            String firstName = splited[0];
            if (!map.containsKey(firstName))
                map.put(firstName, 1);
            else
                map.put(firstName, map.get(firstName) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Duplicate firstName with repetition count");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String name = entry.getKey();
            Integer count = entry.getValue();
            list.add(count);
            if (count > 1)
                System.out.println(name + " repeat " + String.valueOf(count));
        }
        System.out.println("Sort by firstName descending order");
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer var1, Integer var2) {
                return (var2).compareTo(var1);
            }
        });
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Integer count : list) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(count))
                    sortedMap.put(entry.getKey(), count);
            }
        }
        System.out.println(sortedMap.toString());
    }
}

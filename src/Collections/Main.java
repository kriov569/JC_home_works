package Collections;

import java.util.*;
import java.util.stream.Collectors;

//      Задание 1: Реализуй метод, который поменяет ключи и значения в HashMap местами.
//      На вход в метод поступает HashMap <Interger, String>, надо вернуть HashMap<String, Integer>.
//      Выведи результат.
//
public class Main {
    public static Map<String, Integer>
    swapKeysAndValues(HashMap<Integer, String> map) {
        if (map == null) {
            return null;
        }
        return map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey,
                        (existingValue, newValue) -> existingValue));
    }

    public static void main(String[] args) {
        HashMap<Integer, String> nameAndAge = new HashMap<>();
        nameAndAge.put(30, "Ivan");
        nameAndAge.put(40, "Alexei");
        nameAndAge.put(50, "Ivan");

        System.out.println("Original Hash map: " + nameAndAge);

        Map<String, Integer> swappedMap = swapKeysAndValues(nameAndAge);
        System.out.println("Swapped HashMap: " + swappedMap);



//      Задание 3: Реализуй метод, который на вход примет ArrayList строк и удаляет из него все дубликаты,
//      не используя метод contains(). Можно использовать другие коллекции, которые были изучены на уроке.



        ArrayList<String> country = new ArrayList<>();

        country.add("Italy");
        country.add("Belarus");
        country.add("Russia");
        country.add("Ukraine");
        country.add("Russia");
        country.add("Ukraine");

        System.out.println(country);

        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(country);
        country.clear();
        country.addAll(hashSet);

        System.out.println(country);

    }
}

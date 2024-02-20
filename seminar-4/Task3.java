/*
В рамках выполнения задачи необходимо:
1. Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
2. Найдите человека с самым маленьким номером телефона
3. Найдите номер телефона человека чье имя самое большое в алфавитном порядке
*/

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) {

        Map<String, String> phones = getPhones();
        System.out.println(phones);

        String nameMinPhone = getNameThereMinPhone(phones);
        System.out.println(nameMinPhone);

        String largestNamePhone = getLargestNamePhone(phones);
        System.out.println(largestNamePhone);
    }

    private static String getLargestNamePhone(Map<String, String> phones) {
        return phones.entrySet().stream()
                .max((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .get().getKey();
    }

    private static String getNameThereMinPhone(Map<String, String> phones) {
        // return phones.get(
        // phones.keySet().stream().min(Comparator.comparingInt(Integer::parseInt)).get()
        // );
        return phones.entrySet().stream()
                .min((p1, p2) -> Integer.parseInt(p1.getKey()) - Integer.parseInt(p2.getKey()))
                .get().getValue();
    }

    private static Map<String, String> getPhones() {
        Map<String, String> phones = new HashMap<>();
        phones.put("123", "Иван");
        phones.put("456", "Мария");
        phones.put("789", "Семен");
        phones.put("321", "Анна");
        return phones;
    }
}
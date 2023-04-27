// Задача 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    //Добавить функции
    // 1) Добавление номера
    // 2) Вывод всего

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task005_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        while (true) {
            System.out.println("Input operation 1 - Add number; 2 - Print; 3 - Exit");
            int operation = Integer.valueOf(in.next());
            switch (operation) {
                case 3:
                    return;
                case 1:
                    phoneBook.addNumber(in);
                    break;
                case 2:
                    phoneBook.printPhoneBook();
                    break;
            }
        }
    }

    private static class PhoneBook {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        public void addNumber(Scanner in) {
            System.out.println("Input surname");
            String surname = in.next();
            System.out.println("Input phone number");
            String phone = in.next();
            if (!map.containsKey(surname))
                map.put(surname, new ArrayList());
            ArrayList<String> phoneList = map.get(surname);
            phoneList.add(phone);
        }

        public void printPhoneBook() {
            for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
                String surname = entry.getKey();
                ArrayList<String> phoneList = entry.getValue();
                System.out.println(surname + ": " + phoneList.toString());
            }
        }
    }
}

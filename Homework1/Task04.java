// Задача 4. Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.
// под знаками вопроса - одинаковые цифра
// Ввод: 2? + ?5 = 69
// Вывод: 24 + 45 = 69


import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter equation:");
            String equation = sc.nextLine();
            String find = "";
            for(int i=0; i<10; i++) {
                String[] item = equation.split("[+=]");
                for(int j=0; j < item.length; j++) {
                    item[j] = item[j].replace("?", Integer.toString(i)).trim();
                }
                if (item.length == 3 && (Integer.valueOf(item[0]) + Integer.valueOf(item[1])) == Integer.valueOf(item[2])) {
                    find = item[0] + " + " + item[1] + " = " + item[2];
                    break;
                }
            }
            if (find != null && !find.trim().isEmpty()) {
                System.out.printf("Result: %s", find);
            }
            else {
                System.out.print("Result: NOT find");
            }
        }
        finally {
            sc.close();
        }
    }    
}

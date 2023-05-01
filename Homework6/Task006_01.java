import java.util.Map;
import java.util.Scanner;

public class Task006_01 {

    //  Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    //  Создать множество ноутбуков.
    //  Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook(8, 500, "Windows", Notebook.Color.BLACK);
        Notebook notebook2 = new Notebook(16, 1000, "Windows", Notebook.Color.BLACK);
        Notebook notebook3 = new Notebook(8, 500, "Linux", new Notebook.Color(128, 128, 128) /*Gray*/);
        Notebook notebook4 = new Notebook(16, 1200, "Windows", Notebook.Color.WHITE);
        Notebook notebook5 = new Notebook(8, 500, "Linux", new Notebook.Color(128, 128, 128) /*Gray*/);

        System.out.println("Notebook store initialize...");
        NotebookStore store = new NotebookStore();
        store.add(notebook1);
        store.add(notebook2);
        store.add(notebook3);
        store.add(notebook4, 10);
        store.add(notebook5);

        System.out.println("Input notebook parameters for filtering...");
        Scanner in = new Scanner(System.in);
        System.out.println("Minimum RAM in Mb:");
        int ram = in.nextInt();
        System.out.println("Minimum HDD in Mb:");
        int hdd = Integer.valueOf(in.next());
        System.out.println("OS Name (Windows/Linux):");
        String os_name = in.next();
        Notebook notebook_search = new Notebook(ram, hdd, os_name);
        NotebookStore filtered_store = store.filter(notebook_search);
        if (filtered_store.isEmpty())
            System.out.println("No notebook for your criteria");
        else {
            System.out.println("Notebook(s) fro your criteria...");
            for (Map.Entry<Notebook, Long> entry : filtered_store.get_store().entrySet()) {
                Notebook notebook = entry.getKey();
                long count = entry.getValue();
                System.out.println(notebook.toString() + " " + String.valueOf(count) + " amount");
            }
        }
    }

}

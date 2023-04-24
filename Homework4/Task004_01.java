//Задание 1. Пусть дан LinkedList с несколькими элементами. 
// Реализуйте метод(не void), который вернет “перевернутый” список.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task004_01 {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>(Arrays.asList(1, 2, 2, 3));
        System.out.println("List before reversing: " + linkedList.toString());
        LinkedList<Integer> revertList = revertList(linkedList);
        System.out.println("List after reversing: " + revertList.toString());
    }

    public static LinkedList revertList(LinkedList list) {
        LinkedList newList = new LinkedList();
        for (int i = list.size() - 1; i >= 0; i--)
            newList.add(list.get(i));
        return newList;
    }
}

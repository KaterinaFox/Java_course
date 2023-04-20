//Задание 2. Пусть дан произвольный список целых чисел, удалить из него чётные числа

import java.util.ArrayList;
import java.util.List;

public class Task003_2 {
    public static void main(String[] args) {
        int[] array = new int[] {1, 4, 0, 5, 3};
        List<Integer> newArray = new ArrayList<Integer>(array.length);
        for (int i : array)
            if (i %2 == 0)
                newArray.add(i);
        System.out.println(newArray.toString());
    }
}

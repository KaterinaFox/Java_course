//Задача 3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее ариф. из этого списка.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task003_3 {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>(Arrays.asList(1, 4, 0, 5, 3));
        int minValue = Integer.MAX_VALUE;
        int maxValue = -1;
        int sum = 0;
        for (int i : array) {
            if (i < minValue)
                minValue = i;
            if (i > maxValue)
                maxValue = i;
            sum += i;
        }
        System.out.println("min value:"+String.valueOf(minValue));
        System.out.println("max value:"+String.valueOf(maxValue));
        System.out.println("avg value:"+String.valueOf(1.0*sum/array.size()));
    }

}

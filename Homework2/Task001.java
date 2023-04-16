// Задача 1. Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task001 {
    public static void main(String[] args) throws IOException {
        int[] arr = { 15, -93, 114, 16, -7 };
        bubbleSorter(arr);
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index]+" ");
        }  
    }   
    
    static void Log2File(int[] arr) throws IOException {
        FileWriter file = new FileWriter("log.txt", true);
        BufferedWriter outputWriter = new BufferedWriter(file);
        outputWriter.newLine();
        for (int i = 0; i < arr.length; i++) {
          outputWriter.write(Integer.toString(arr[i])+" ");
        }
        outputWriter.flush();  
        outputWriter.close();  
    }

    static void bubbleSorter(int[] arr) throws IOException {
       
        for (int i = arr.length-1; i > 0; i--) {
            int temp;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                Log2File(arr);
            }   
        }
    }    
}

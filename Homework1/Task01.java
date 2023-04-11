// Задача. 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), а так же n! 
// (произведение чисел от 1 до n)
// Ввод:5
// Треугольное число 1 + 2 + 3 + 4 + 5 = 15
// n! 1 * 2 * 3 * 4 * 5 = 120

package Homework.Homework1;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        System.out.printf("Number: ");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        sc.close();
        int triangle_num = 0;
        int factorial_num = 1;
        for (int index = 1; index <= value; index++) {
            triangle_num = triangle_num + index;
            factorial_num = factorial_num * index;
        }
        System.out.printf("Triangle number: %d", triangle_num);
        System.out.println();
        System.out.printf("Factorial number: %d", factorial_num);
    }
}

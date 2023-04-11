// Задача 3. Реализовать простой калькулятор (+ - / *)
// Ввод числа ->
// Ввод знака ->
// Ввод числа ->

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter first operand:");
            int operand1 = Integer.valueOf(sc.nextLine());
            System.out.print("Enter operator:");
            String operator = sc.nextLine();
            System.out.print("Enter second operand:");
            int operand2 = sc.nextInt();
            float result = 0;
            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "/":
                    result = Float.valueOf(operand1) / operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                default:
                    System.out.print("Unknown operand");
                    return;
            }
            System.out.printf("Result: %f", result);
        }
        finally {
            sc.close();
        }
    }        
}

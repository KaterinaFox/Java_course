// Задание 3. В калькулятор добавьте возможность отменить последнюю операцию.
// Поддерживает целочисленные операции +-*/ Отмена Выход

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Task004_03 {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.calculate();
    }

    private static class Calculator {
        private Scanner in = new Scanner(System.in);
        private int result;
        private LinkedList<Integer> history = new LinkedList<Integer>();

        enum Operation {
            NONE,
            PLUS,
            MINUS,
            DIVISION,
            MULTIPLICATION,
            BACK,
            EXIT
        }

        Operation prevOperation = Operation.NONE;
        private static HashMap<String, Operation> map = new HashMap<String, Operation>() {
            {
                put("+", Operation.PLUS);
                put("-", Operation.MINUS);
                put("/", Operation.DIVISION);
                put("*", Operation.MULTIPLICATION);
                put("Отмена", Operation.BACK);
                put("Выход", Operation.EXIT);
            }
        };

        private Operation parse(String s) {
            if (map.containsKey(s))
                return map.get(s);
            else
                return Operation.NONE;
        }

        private boolean isBinaryOperator(Operation operation) {
            return operation == Operation.PLUS || operation == Operation.MINUS || operation == Operation.DIVISION
                    || operation == Operation.MULTIPLICATION;
        }

        private void doWork(Operation operation, int operand) {
            switch (operation) {
                case PLUS:
                    result = result + operand;
                    break;
                case MINUS:
                    result = result - operand;
                    break;
                case DIVISION:
                    result = result / operand;
                    break;
                case MULTIPLICATION:
                    result = result * operand;
                    break;
                case BACK:
                    if (history.size() > 0) {
                        if (isBinaryOperator(prevOperation))
                            history.removeLast();
                        result = history.removeLast();
                        System.out.println("Result:\n" + String.valueOf(result));
                    } else {
                        System.out.println("History empty");
                    }
                    break;
            }
            prevOperation = operation;
            if (isBinaryOperator(operation)) {
                history.add(result);
                System.out.println("Result:\n" + String.valueOf(result));
            }
        }

        public void calculate() {
            System.out.println("Calculator input operand in operation:");
            result = in.nextInt();
            while (true) {
                String s = in.next();
                Operation operation = parse(s);
                int operand = 0;
                if (isBinaryOperator(operation))
                    operand = Integer.valueOf(in.next());
                else if (operation == Operation.BACK)
                    operand = 0;
                else if (operation == Operation.EXIT)
                    return;
                doWork(operation, operand);
            }
        }
    }
}

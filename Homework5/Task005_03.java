//Задача 3. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. 
//  И вывести Доску. Пример вывода доски 8x8
// 0x000000
// 0000x000
// 00x00000
import java.util.*;

public class Task005_03 {
    public static void main(String[] args) {
        List<Integer> columns = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Map<Integer, List<Integer>> rows = new HashMap<>();
        for (int column : columns) {
            rows.put(column, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        }
        CSP<Integer, Integer> csp = new CSP<>(columns, rows);
        csp.addConstraint(new QueensConstraint(columns));
        Map<Integer, Integer> solution = csp.backtrackingSearch();
        if (solution == null) {
            System.out.println("No solution found!");
        } else {
            System.out.println(solution);
            char[][] mat = new char[8][8];
            for (int i = 0; i < 8; i++)
                Arrays.fill(mat[i], '0');
            for (Map.Entry<Integer, Integer> entry : solution.entrySet()) {
                int column = entry.getKey() - 1;
                int row = entry.getValue() - 1;
                mat[row][column] = 'x';
            }
            for (char[] chars: mat) {
                String s = Arrays.toString(chars).replaceAll(",", "").replace(" ", "");
                System.out.println(s);
            }
        }
    }

    // V — тип переменной, D — тип домена.
    public static abstract class Constraint<V, D> {
        // Переменные, для которых существует ограничение
        protected List<V> variables;
        public Constraint(List<V> variables) {
            this.variables = variables;
        }
        // Необходимо переопределить в подклассах
        public abstract boolean satisfied(Map<V, D> assignment);
    }

    // Constraint satisfaction problem (проблема удовлетворения ограничений)
    public static class CSP<V, D> {
        private List<V> variables;
        private Map<V, List<D>> domains;
        private Map<V, List<Constraint<V, D>>> constraints = new HashMap<>();

        public CSP(List<V> variables, Map<V, List<D>> domains) {
            this.variables = variables;
            this.domains = domains;
            for (V variable : variables) {
                constraints.put(variable, new ArrayList<>());
                if (!domains.containsKey(variable)) {
                    throw new IllegalArgumentException("Every variable should have a domain assigned to it.");
                }
            }
        }

        public void addConstraint(Constraint<V, D> constraint) {
            for (V variable : constraint.variables) {
                if (!variables.contains(variable)) {
                    throw new IllegalArgumentException("Variable in constraint not in CSP");
                }
                constraints.get(variable).add(constraint);
            }
        }

        // Проверяем, соответствует ли присваивание значения,
        // проверяя все ограничения для данной переменной
        public boolean consistent(V variable, Map<V, D> assignment) {
            for (Constraint<V, D> constraint : constraints.get(variable)) {
                if (!constraint.satisfied(assignment)) {
                    return false;
                }
            }
            return true;
        }

        public Map<V, D> backtrackingSearch(Map<V, D> assignment) {
            // присваивание завершено, если существует присваивание
            // для каждой переменной (базовый случай)
            if (assignment.size() == variables.size()) {
                return assignment;
            }
            // получить все переменные из CSP, но не из присваивания
            V unassigned = variables.stream().filter(v -> !assignment.containsKey(v)).findFirst().get();
            // получить все возможные значения области определения
            // для первой переменной без присваивания
            for (D value : domains.get(unassigned)) {
                // мелкая копия присваивания, которую мы можем изменить
                Map<V, D> localAssignment = new HashMap<>(assignment);
                localAssignment.put(unassigned, value);
                // если нет противоречий, продолжаем рекурсию
                if (consistent(unassigned, localAssignment)) {
                    Map<V, D> result = backtrackingSearch(localAssignment);
                    // если результат не найден, заканчиваем возвраты
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        }

        // вспомогательный класс функции backtrackingSearch
        public Map<V, D> backtrackingSearch() {
            return backtrackingSearch(new HashMap<>());
        }
    }

    public static class QueensConstraint extends Constraint<Integer, Integer> {
        private List<Integer> columns;

        public QueensConstraint(List<Integer> columns) {
            super(columns);
            this.columns = columns;
        }

        @Override
        public boolean satisfied(Map<Integer, Integer> assignment) {
            for (Map.Entry<Integer, Integer> item : assignment.entrySet()) {
                // q1c = ферзь на 1-й вертикали, q1r = ферзь на 1-й горизонтали
                int q1c = item.getKey();
                int q1r = item.getValue();
                // q2c = ферзь на 2-й вертикали
                for (int q2c = q1c + 1; q2c <= columns.size(); q2c++) {
                    if (assignment.containsKey(q2c)) {
                        // q2r = ферзь на 2-й горизонтали
                        int q2r = assignment.get(q2c);
                        // тот же ряд?
                        if (q1r == q2r) {
                            return false;
                        }
                        // одна диагональ?
                        if (Math.abs(q1r - q2r) == Math.abs(q1c - q2c)) {
                            return false;
                        }
                    }
                }
            }
            return true; // нет конфликтов
        }
    }
}

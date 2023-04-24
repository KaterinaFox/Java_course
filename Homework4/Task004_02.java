
//Задание 2. Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.
import java.util.LinkedList;

public class Task004_02 {

    public static void main(String[] args) {
        queue<Integer> queueList = new queue<Integer>();
        queueList.enqueue(1);
        queueList.enqueue(2);
        System.out.println("queue list: " + queueList.toString());
        int firstElement = queueList.first();
        System.out.println("first queue element: " + String.valueOf(firstElement));
        queueList.dequeue();
        System.out.println("queue list after remove first element: " + queueList.toString());
    }

    private static class queue<T> {
        private LinkedList<T> list = new LinkedList<T>();

        public void enqueue(T t) {
            list.add(t);
        }

        public T dequeue() {
            T t = list.removeFirst();
            return t;
        }

        public T first() {
            T t = list.getFirst();
            return t;
        }

        @Override
        public String toString() {
            return list.toString();
        }
    }
}

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;

// Задача 2
// Дана строка (получение через обычный файл)

// "фамилия":"Иванов","оценка":"5", "предмет":"Математика"
// "фамилия":"Петрова","оценка":"4", "предмет":"Информатика"

// Написать метод(ы), которые распарсят строку и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет]

// Предмет вывода в консоль:
// Студент Иванов получил 5 по предмету Математика.
public class Task002 {

    private static class Student {
        String name;
        String grade;
        String subject;

        // Формирование строки
        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            str
                .append("Студент " + name)
                .append(" получил " + grade)
                .append(" по предмету " + subject);
            return str.toString();
        }

        // Разбор из строки
        public void parse(String line) throws IOException {
            String[] s = line.split(",");
            for(int i = 0; i < s.length; i++) {
                String[] item = s[i].split(":");
                String item0 = item[0].replace("\"", "");
                String item1 = item[1].replace("\"", "");
                switch (item0) {
                    case "фамилия":
                        name = item1;
                        break;
                    case "оценка":
                        grade = item1;
                        break;
                    case "предмет":
                        subject = item1;
                        break;
                    default:
                        throw new IOException("Error on parse student "+ line);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Получение пути к java файлу
        String path = Paths.get("", args).toAbsolutePath().toString();
        String fileName = path + "\\log002.txt";
        // Создание файла с оценками
        createLog(fileName);
        // Разбор файла в массив
        ArrayList<Student> students = parseLog(fileName);
        // Форматирование массива в строку
        String formatData = formatLog(students);
        System.out.println(formatData);
    }

    private static void createLog(String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter
                (new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
        writer.write(
        "\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"\n"+
            "\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\""
        );
        writer.close();
    }

    private static ArrayList<Student>parseLog(String fileName) throws IOException {
        ArrayList<Student> students = new ArrayList<Student>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName), "UTF-8"));
        String line = reader.readLine();
        while (line != null) {
            Student student = new Student();
            student.parse(line);
            //System.out.println(students.toString());
            students.add(student);
            line = reader.readLine();
        }
        reader.close();
        return  students;
    }

    private static String formatLog(ArrayList<Student> students) {
        StringBuilder str = new StringBuilder();
        for(Student s: students)
            str.append(s.toString()+ "\n");
        return str.toString();
    }
}

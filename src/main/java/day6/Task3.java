package day6;

public class Task3 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Виктор Петрович", "Математика");
        Student student = new Student("Светлана");
        teacher.evaluate(student);
        teacher.setSubject("Русский");
        teacher.evaluate(student);
    }
}

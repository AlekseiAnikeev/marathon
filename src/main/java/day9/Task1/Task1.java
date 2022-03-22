package day9.Task1;

public class Task1 {
    public static void main(String[] args) {
        Student student = new Student("Георгий", "Робототехника");
        Teacher teacher = new Teacher("Петр Петрович", "Математика");
        System.out.println(student.getGroupName());
        System.out.println(teacher.getSubjectName());
        student.printInfo();
        teacher.printInfo();
    }
}

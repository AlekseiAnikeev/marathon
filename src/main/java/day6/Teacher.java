package day6;

import java.util.Random;

public class Teacher {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void evaluate(Student student) {
        String text = "Преподаватель %s оценил студента с именем %s по предмету %s на оценку %s.\n";
        int grade = (int) (Math.random() * 4) + 2;
        String textGrade;
        switch (grade) {
            case 5:
                textGrade = "отлично";
                break;
            case 4:
                textGrade = "хорошо";
                break;
            case 3:
                textGrade = "удовлетворительно";
                break;
            default:
                textGrade = "неудовлетворительно";
                break;
        }
        System.out.println(grade);
        System.out.println( textGrade);
        System.out.printf(text,name, student.getName(),subject, textGrade);
    }
}

package Students;

import java.util.function.Function;

public record Student(
        int ID,
        String name,
        String course,
        int age,
        int gradeAverage,
        int phoneNumber,
        String email

) {
    public static int studentID = 0;

    public Student(String name, String course, int age, int gradeAverage, int phoneNumber) {
        this(++studentID, name, course, age, gradeAverage, phoneNumber, name+ "@brighton.co.uk" );
    }

    
}

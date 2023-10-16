package Students;

import java.util.function.Function;

public record Student(
        int ID,
        String name,
        String course,
        int gradeAverage,
        int phoneNumber,
        String email

) {
    public static int studentID = 0;

    public Student(String name, String course, int gradeAverage, int phoneNumber, String email) {
        this(++studentID, name, course, gradeAverage, phoneNumber,email = name+ "@brighton.co.uk" );
    }

    
}
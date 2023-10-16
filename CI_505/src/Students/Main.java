package Students;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.lang.Character.getName;

public class Main {
    public static void main(String[] args) {

        // Collection of student records.
        List<Student> students = new ArrayList<>();

        

        Student s1 = new Student("Marci", "CS",55, 36546 );
        Student s2 = new Student("Sam", "WebDev",70, 3654316);
        Student s3 = new Student("Grevor", "CS",60, 765316);
        students.add(new Student("Mary", "CS", 65, 4569273));
        students.add(new Student("Mike", "WebDev", 59, 64233483));
        students.add(new Student("Kevin", "CyberSec", 85, 76543224));
        students.add(s1);
        students.add(s3);
        students.add(s2);
        System.out.println(students);

        Function<Student, String> get_Name =
                i -> i.name();

        Function<Student, Integer> get_grade =
                i -> i.gradeAverage();
        
        Function<Student, String> get_course =
                i -> i.course();

        Function<Student, Integer> get_ID = 
                i -> i.ID();

        Function<Student, String> get_email = 
                i -> i.email();

        Function<Student, Integer> get_num =
                i -> i.phoneNumber();

        

        Predicate<Student> doesCS =
                student -> get_course.apply(student).contains("CS");

        // function to say the name of the student object
        Consumer<Student> sayName =
            input -> System.out.println("Student's name with ID " + get_ID.apply(input) + " is: " + get_Name.apply(input));

        Consumer<Student> say_desc = 
                input -> System.out.println("Student's name is " + get_Name.apply(input) +
                ". Their ID is :" + get_ID.apply(input) + ", and their average grade is " + get_grade.apply(input) +
                ". They can be reached at phone number " + get_num.apply(input) + ", or at " + get_email.apply(input));

        Consumer<Student> sayGrade =
                input -> System.out.println("Student grade is : " + get_grade.apply(input));

        
        // function that replaces print() and outputs the input
        // decided to use the Object parameter so that it would take 
        

        Consumer<Object> say =
                input -> System.out.println(input);

        say.accept("hey");
        say.accept("i wanna be a space crab");
        say.accept(3);
        say.accept("The ID of student 1 is: " + get_ID.apply(s1));
        say.accept(s1);
        say.accept(s2);
        say.accept(s3);
        say.accept(get_email.apply(s3));

        Function<String, Boolean> strM =
                input -> input.startsWith("M");


        Predicate<Student> above70 =
                student -> get_grade.apply(student) > 70;
        
        Predicate<Student> startsWithM =
                input -> strM.apply(get_Name.apply(input));
                // input -> get_Name.andThen(strM).accept(input);

        List<String> newStudents =
                students.stream()
                        .filter(doesCS)
                        .map(student -> student.name())
                        .collect(Collectors.toList());

        // List<Student> student_list_2 =
        //         students.stream()
        //         .filter(startsWithM)
        //         .collect(Collectors.toList());

        Function<Student, String> getDescription =
        student -> {
                String description = "Student's name is " + get_Name.apply(student) +
                        ". Their ID is :" + get_ID.apply(student) + ", and their average grade is " + get_grade.apply(student) +
                        ". They can be reached at phone number " + get_num.apply(student) + ", or at " + get_email.apply(student) + "\n";
                return description;
            };

        List<String> student_list_2 =
                students.stream()
                .filter(startsWithM)
                .map(getDescription)
                .collect(Collectors.toList());
        
        say.accept("The Student list 2 is: " +student_list_2);

        say.accept("The list of students that do CS is: " + newStudents);
        
        List<Student> allStudents =
                students.stream()
                        .collect(Collectors.toList());
        for (Student s : allStudents) {
            sayName.andThen(sayGrade).accept(s);
        }

//        BiConsumer<List, Function> sayEveryonesName =
//
    }
}

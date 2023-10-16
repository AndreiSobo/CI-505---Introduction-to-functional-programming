package Students;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.Character.getName;

public class Main {
    public static void main(String[] args) {

        // Collection of student records.
        List<Student> students = new ArrayList<>();

        

        Student s1 = new Student("Marci", "sahel",55, 36546, "cabbage");
        students.add(new Student("Mary", "CS", 65, 4569273,"cherry"));
        students.add(new Student("Mike", "WebDev", 59, 64233483, "habsburg"));
        students.add(new Student("Kevin", "CyberSec", 85, 76543224, "cissko"));
        students.add(s1);
        System.out.println(students);

        Function<Student, String> get_Name =
                i -> i.name();

        Function<Student, Integer> get_grade =
                i -> i.gradeAverage();
        
        Function<Student, String> get_course =
                i -> i.course();

        Function<Student, Integer> get_ID = 
                i -> i.ID();

        
        

        

        Predicate<Student> doesCS =
                student -> student.course().contains("CS");
        // function to say the name of the student object
        Consumer<Student> sayName =
            input -> System.out.println("The name is: " + get_Name.apply(input));
        Consumer<Student> sayGrade =
                input -> System.out.println(" grade is : " + get_grade.apply(input));

        

        // function that replaces print() and outputs the input
        // Consumer<String> say =
        //         input -> System.out.println(input);

        Consumer<Object> say =
                input -> System.out.println(input);

        say.accept("hey");
        say.accept("i wanna be a space crab");
        say.accept(3);
        


        Predicate<Student> above70 =
                student -> student.gradeAverage() > 70;
        List<String> newStudents =
                students.stream()
                        .filter(doesCS)
                        .map(student -> student.name())
                        .collect(Collectors.toList());

        System.out.println(newStudents);
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

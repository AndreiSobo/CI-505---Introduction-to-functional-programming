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

// TODO make comments explaining everything

public class Main {
    public static void main(String[] args) {

        // Collection of student records.
        List<Student> students = new ArrayList<>();

        

        Student s1 = new Student("Marci", "CS",20, 55, 36546 );
        Student s2 = new Student("Sam", "WebDev", 33, 70, 3654316);
        Student s3 = new Student("Grevor", "CS", 19, 60, 765316);
        students.add(new Student("Mary", "CS", 22, 65, 4569273));
        students.add(new Student("Mike", "WebDev", 39, 59, 64233483));
        students.add(new Student("Kevin", "CyberSec", 27, 85, 76543224));
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

        // function that replaces print() and outputs the input
        Consumer<Object> say =
                input -> System.out.println(input);
        

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

        
        
        // make a query that uses sa_desc on all elements contained in "students"
        
        

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
        System.out.println("\n");
        System.out.println("Applies the doesCS predicate on filter and them geets name of students");
        List<String> newStudents =
                students.stream()
                        .filter(doesCS)
                        .map(student -> student.name())
                        .collect(Collectors.toList());
        say.accept("The list of students that do CS is: " + newStudents);
        say.accept("\n");
        /// make use of above70 Predicate
        List<Student> above70Students = 
                students.stream()
                .filter(above70)
                .collect(Collectors.toList());
        say.accept("The list of students that have above 70");
        say.accept(above70Students);

        Function<Student, String> getDescription =
        student -> {
                String description = "Student's name is " + get_Name.apply(student) +
                        ". Their ID is :" + get_ID.apply(student) + ", and their average grade is " + get_grade.apply(student) +
                        ". They can be reached at phone number " + get_num.apply(student) + ", or at " + get_email.apply(student) + "\n";
                return description;
            };
        System.out.println("\n");
        System.out.println("make use of starts with 'M' and the maps getDescription");
        List<String> studentCompleteDescription =
                students.stream()
                .filter(startsWithM)
                .map(getDescription)
                .collect(Collectors.toList());
        say.accept("The complete description of students: " +studentCompleteDescription);

        
        
        List<Student> allStudents =
                students.stream()
                        .collect(Collectors.toList());
        // make use of say_desc on all the students in the "students" stream()
        // printing the sholw desc
        students.forEach(say_desc);

        // create a string with the complete description of all students
        String all_students_desc = students.stream()
                .map(getDescription)
                .collect(Collectors.joining("\n"));

        say.accept("\n");
        say.accept("The complete description of all students");
        say.accept(all_students_desc);
        //can look at a functional way to implement thais
        // for (Student s : allStudents) {
        //     sayName.andThen(sayGrade).accept(s);
        // }
        


//       Add an element of BiConsumer
//  BiConsumer<List, Function> sayEveryonesName =

        // Add elements used in last lecture - week4:
        // Data transformations using .map(): 
        Predicate<Student> hasEmail = student -> get_email.apply(student) != null;

        boolean anyStudentHasEmail = students.stream().anyMatch(hasEmail);

        if (anyStudentHasEmail) {
                System.out.println("At least one student has an email address.");
        } else {
                System.out.println("No student has an email address.");
        }
        List<Student> 
        // Use min / max / sorted, from the stream() API
        // make use of Reduce() and ways to implement that

        // Using .min() and .max() from the lecture session, 
        //identify the oldest and the youngest student in the Stream

    }
}

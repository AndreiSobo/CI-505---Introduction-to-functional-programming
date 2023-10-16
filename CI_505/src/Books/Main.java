//package Books;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//public class Main {
//    public static void main(String[] args) {
//
//        List<Book> books = new ArrayList<>();
//
//        books.add(new Book("war and peace", "tolstoi", 225, 1993));
//        books.add(new Book("coffee", "coffee maker", 235, 2003));
//        books.add(new Book("computers", "bill gates", 458, 2023));
//        books.add(new Book("windows", "Author book4", 536, 1842));
//        books.add(new Book("mouse traps", "Random author b5", 1034, 1535));
//
//
//        System.out.println(books);
//        System.out.println("\n");
//
//        Predicate<Book> cdn = book -> book.yearReleased() > 2000;
//        Predicate<Book> startsWith =
//                book -> book.title().startsWith("c");
//
//        List<Book> after2000 = books.stream()
//                .filter(cdn)
//                .filter(startsWith)
//                .collect(Collectors.toList());
//        System.out.println(after2000);
//
//
//    }
//    }

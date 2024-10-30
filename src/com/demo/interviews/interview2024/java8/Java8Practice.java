package com.demo.interviews.interview2024.java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Dhruval Vaishnav Created on 25-10-2024
 */
public class Java8Practice {
    public static void main(String[] args) {
        //You have a list of Employee objects with fields name, age, and salary.
        // Write a stream operation to find the average salary of employees who are older than 30.
        List<Employee> employeeList = Arrays.asList(new Employee("Dhruval", 25, 10000), new Employee("Raj", 35, 20000), new Employee("Ravi", 45, 30000), new Employee("Rahul", 55, 40000), new Employee("Rohan", 65, 50000));

        employeeList.stream().filter(x -> x.age > 30).mapToDouble(x -> x.salary).average().ifPresent(x -> System.out.println("Average salary of employees who are older than 30: " + x));
        System.out.println("=========================================================================================");

        //You have a list of Product objects with fields name, price, and category.
        // Write a stream operation to get a list of product names that belong to the "Electronics" category and have a price greater than $100.
        List<Product> productList = Arrays.asList(new Product("Laptop", 50000, "Electronics"), new Product("Mobile", 20000, "Electronics"), new Product("Shirt", 500, "Clothing"), new Product("Shoes", 1000, "Footwear"), new Product("TV", 40000, "Electronics"), new Product("Smartwatch", 99, "Electronics"), new Product("Watch", 5000, "Accessories"));

        List<Product> filteredProductList = productList.stream().filter(x -> x.category.equalsIgnoreCase("Electronics") && x.price > 100).collect(Collectors.toList());
        System.out.println("Product names that belong to the 'Electronics' category and have a price greater than $100: " + filteredProductList);
        System.out.println("=========================================================================================");

        //Given a list of words, write a stream operation to count how many times the word "java" appears (case-insensitive) in the list.
        List<String> words = Arrays.asList("Java", "Python", "Java", "C++", "Java", "JavaScript", "Java", "Ruby", "Java", "Java");
        int countOfJavaWord = (int) words.stream().filter(x -> x.equalsIgnoreCase("Java")).count();
        System.out.println("Count of 'Java' word in the list: " + countOfJavaWord);
        System.out.println("=========================================================================================");

        // You have a list of Order objects, each with a customerId and totalAmount.
        // Write a stream operation to group the orders by customerId and calculate the total amount spent by each customer.
        List<Order> orders = Arrays.asList(
                new Order("C001", 1000),
                new Order("C002", 2000),
                new Order("C001", 3000),
                new Order("C003", 4000),
                new Order("C002", 5000),
                new Order("C001", 6000),
                new Order("C003", 7000),
                new Order("C002", 8000),
                new Order("C001", 9000),
                new Order("C003", 10000));

        Map<String, Double> collect = orders.stream().collect(Collectors.groupingBy(x -> x.customerId, Collectors.summingDouble(x -> x.totalAmount)));
        System.out.println("Total amount spent by each customer: " + collect);
        System.out.println("=========================================================================================");

        //You have a list of integers. Write a stream operation to find the top 3 largest unique integers from the list.
        List<Integer> intList = Arrays.asList(12, 23, 45, 67, 89, 89, 33, 11, 40, 65, 77);
        intList.stream().sorted(Collections.reverseOrder()).distinct().limit(3).forEach(x-> System.out.print(x + " "));
        System.out.println();
        System.out.println("=========================================================================================");

        //You have two lists: one of String values and another of Integer values.
        // Write a stream operation to merge these two lists into a single list of strings, where each integer is converted to a string and appended to the original strings.
        List<String> names = Arrays.asList("John", "Alice", "Bob", "David", "Eve");
        List<Integer> rollNumbers = Arrays.asList(101, 102, 103, 104, 105);

        List<String> mergedList = names.stream()
                .flatMap(x -> rollNumbers.stream().map(y -> x + y)).collect(Collectors.toList());
        System.out.println("Merged list: " + mergedList);

        // I want one key from names and one key from rollNumbers to be merged into a single string for eg : John101, Alice102, Bob103, David104, Eve105
        List<String> mergedList1 = names.stream()
                .map(x -> x + rollNumbers.get(names.indexOf(x))).collect(Collectors.toList());
        System.out.println("Merged list1: " + mergedList1);
        System.out.println("=========================================================================================");

        //Given a list of User objects with fields username and email,
        // write a stream operation to find the first user whose email contains "example.com"
        List<User> userList = Arrays.asList(
                new User("john", "john@test.com"),
                new User("alice", "alice@example.com"),
                new User("peter", "peter@example.com"),
                new User("bernal", "bernal@test.com"),
                new User("diljith", "diljith@test.com"),
                new User("zakir", "zakir@example.com"),
                new User("kishan", "kishan@test.com"));

        User firstUserWithExample = userList.stream().filter(x->x.email.contains("example.com")).findFirst().get();
        System.out.println("First user whose email contains 'example.com': " + firstUserWithExample);

        System.out.println("=========================================================================================");
        //You have a list of integers that contains duplicates.
        // Write a stream operation to return a sorted list of distinct integers from this list.
        List<Integer> numbers = Arrays.asList(12, 23, 45, 67, 89, 89, 33, 11, 40, 65, 77);
        numbers.stream().sorted().distinct().forEach(x-> System.out.print(x + " "));
        System.out.println();
        System.out.println("=========================================================================================");

        //Given a list of Book objects with fields title, author, and publicationYear,
        // write a stream operation to get a list of titles of books published after 2010, sorted by publication year.
        List<Book> books = Arrays.asList(
                new Book("Java Programming", "John Doe", 2000),
                new Book("Python Programming", "Alice", 2015),
                new Book("C++ Programming", "Bob", 2012),
                new Book("JavaScript Programming", "David", 2018),
                new Book("Ruby Programming", "Eve", 2010),
                new Book("PHP Programming", "Peter", 2011),
                new Book("Angular Programming", "Bernal", 2019),
                new Book("React Programming", "Diljith", 2017),
                new Book("Vue Programming", "Zakir", 2016),
                new Book("Spring Programming", "Kishan", 2014));

        List<String> titles = books.stream().filter(x -> x.publicationYear > 2010)
                .sorted(Comparator.comparingInt(x->x.publicationYear)).map(x -> (String) x.title).collect(Collectors.toList());
        System.out.println("Titles of books published after 2010, sorted by publication year: " + titles);
        System.out.println("=========================================================================================");

        // You have a list of integers. Write a stream operation to find the sum of the squares of the top 5 odd numbers from the list.
        List<Integer> nums = Arrays.asList(12, 23, 45, 67, 89, 89, 33, 11, 40, 65, 77);
        System.out.println("List of top 5 odd numbers: " + nums.stream().filter(x -> x % 2 != 0).distinct().limit(5).collect(Collectors.toList()));
        Integer sum = nums.stream().filter(x -> x % 2 != 0).distinct().limit(5).map(x -> x * x).reduce(Integer::sum).get();
        System.out.println("Sum of the squares of the top 5 odd numbers: " + sum);
        System.out.println("=========================================================================================");

    }


}

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}

class Product {
    String name;
    double price;
    String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return category + " - " + name + " - " + price;
    }
}

class Order {
    String customerId;
    double totalAmount;

    public Order(String customerId, double totalAmount) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
    }
}

class User {
    String username;
    String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return username + " - " + email;
    }
}

class Book {
    String title;
    String author;
    int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return title + " - " + author + " - " + publicationYear;
    }

}
package com.demo.interviews;

import java.util.ArrayList;
import java.util.List;

class Book {
    private Author author;

    public Book(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                '}';
    }
}

class Author {
    private String fn;
    private String ln;
    private int age;

    public Author(String fn, String ln, int age) {
        this.fn = fn;
        this.ln = ln;
        this.age = age;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "fn='" + fn + '\'' +
                ", ln='" + ln + '\'' +
                ", age=" + age +
                '}';
    }
}

public class AgeMoreThan50 {
    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(new Author("Jigar", "Kakadiya", 56)));
        bookList.add(new Book(new Author("Jigar", "K", 49)));
        bookList.add(new Book(new Author("Jigar", "S", 65)));
        bookList.add(new Book(new Author("Jigar", "I", 99)));

        bookList.stream().filter(e -> e.getAuthor().getAge() >= 50).forEach(System.out::println);
    }

}

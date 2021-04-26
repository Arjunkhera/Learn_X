package com.arjun.oop;

import java.util.Arrays;

class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public Book(String title, int yearOfPublishing, String[] authors) {
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = authors;
    }

    @Override
    public String toString() {
        StringBuilder authors = new StringBuilder();
        Arrays.stream(this.authors).forEach(author -> authors.append(author + ","));
        if (this.authors.length != 0) {
            authors.insert(0, ",authors=[");
            authors.replace(authors.length() - 1, authors.length(), "]");
        }
        return "title=" + title +
                ",yearOfPublishing=" + yearOfPublishing +
                authors;
    }
}
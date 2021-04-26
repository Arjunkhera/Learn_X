package com.arjun.generics;

import com.arjun.generics.examples.SampleClasses;

import java.util.ArrayList;
import java.util.List;

public class Wildcard {

    public void upperBoundIntroduction() {
        List<? extends SampleClasses.Book> storage = new ArrayList<>();

        List<SampleClasses.Album> albums = new ArrayList<>();
        storage = albums; // it works, Album is a subtype of Book

        List<SampleClasses.Booklet> booklets = new ArrayList<>();
        storage = booklets; // it works, Booklet is a subtype of Book

        List<SampleClasses.AudioFile> recordings = new ArrayList<>();
        // storage = recordings; // compile-time error, AudioFile is not a subtype of Book
    }

    public void upperBoundedMethod(List<? extends SampleClasses.Book> books) {
        SampleClasses.Book book = books.get(0); // It is fine

        // does not work since a parent class cannot be downcast to a child class
        // SampleClasses.Album album = books.get(0);

        books.add(null); // also fine, because of null is a special type-independent value
        // following give compile time error
        // books.add(new Album());
        // books.add(new Book());
    }

    public void lowerBoundIntroduction() {
        List<? super SampleClasses.Album> storage = new ArrayList<>();

        List<SampleClasses.Album> albums = new ArrayList<>();
        storage = albums; // it works

        List<SampleClasses.Book> books = new ArrayList<>();
        storage = books; // it works, Book is a supertype for Album

        List<SampleClasses.Booklet> booklets = new ArrayList<>();
        // storage = booklets; // compile-time error, Booklet is not a supertype for Album
    }

    public void lowerBoundedMethod(List<? super SampleClasses.Album> albums) {
        Object object = albums.get(0); // it is ok. Object is upper bound of Album

        // does not work since a parent class cannot be downcast to a child class
        // SampleClasses.Book book = albums.get(0);
        // SampleClasses.Album album = albums.get(0);

        albums.add(null); // OK, null is type-independent
        albums.add(new SampleClasses.Album());  // OK
        // following give compile time error
        // albums.add(new Object());
        // albums.add(new Book());
    }
}

package com.arjun.learn.generics;

import java.awt.print.Book;

public class TypeBound {
    static class Book {
    }

    static class Brochure extends Book {

        private String name;

        Brochure(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
        }
    }

    static class Shelf<T extends java.awt.print.Book> {
        private T object;

        public T getElement() {
            return this.object;
        }

        public void setElement(T object) {
            this.object = object;
        }
    }
}


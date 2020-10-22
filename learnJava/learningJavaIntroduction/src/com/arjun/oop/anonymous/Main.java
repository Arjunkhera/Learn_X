package com.arjun.oop.anonymous;

public class Main {

    public static void main(String[] args) {

        SpeakingEntity englishSpeakingPerson = new SpeakingEntity() {

            @Override
            public void sayHello() {
                System.out.println("Hello!");
            }

            @Override
            public void sayBye() {
                System.out.println("Bye!");
            }
        };

        englishSpeakingPerson.sayHello();
        englishSpeakingPerson.sayBye();

    }
}

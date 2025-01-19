package com.arjun.oop.anonymous;

public class Main {
    int classVariable = 1;

    public void anonymous() {
        final int innerVariable = 2;
        int effectivelyFinalInnerVariable = 3;

        SpeakingEntity englishSpeakingPerson = new SpeakingEntity() {
            public void variables() {
                System.out.println("Anonymous class can access containing class variables : " + classVariable);
                System.out.println("It can access enclosing method variables if");
                System.out.println("They are final : " + innerVariable);
                System.out.println("Or effectively final " + effectivelyFinalInnerVariable);
            }

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

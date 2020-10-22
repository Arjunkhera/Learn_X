package com.arjun.test.first;

import com.arjun.test.first.innerFirst.C;

public class B {
    private void methodB() {
        A a = new A();

        int checkFirst = a.field2;
        int checkSecond = a.field3;
        int checkThird = a.field4;

//        C c = new C();
//        int checkFirst = c.field2;
//        int checkSecond = c.field3;
    }
}

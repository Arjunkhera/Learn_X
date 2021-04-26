package com.arjun.oop.modifiers.inner;

import com.arjun.oop.modifiers.OuterA;

public class InnerB {
    public void modifyObjectVariable(int newValue) {
        OuterA outerA = new OuterA();
        // we only get this since this variable was public
        outerA.publicField = newValue;
    }
}

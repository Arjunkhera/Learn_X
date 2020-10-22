package com.arjun.oop.modifiers.inner;

import com.arjun.oop.modifiers.Common;
import com.arjun.oop.modifiers.OuterA;

public class InnerA extends OuterA {
    public void modifyParentVariable(int newValue) {
        // no access since its private, need to use getters and setters
        // this.privateField;

        // cannot access since we are not in same package
        // this.defaultField = newValue;

        // the following will also work
        this.protectedField = newValue;
        this.publicField = newValue;
    }

    public void modifyObjectVariable(int newValue) {
        Common common = new Common();

        // not in same package, hence not accessible
        // common.defaultField = newValue;
        // not a subclass, hence not accessible
        // common.protectedField = newValue;
        // public, therefore accessible
        common.publicField = newValue;
    }
}

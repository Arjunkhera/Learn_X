package com.arjun.oop.modifiers;

import com.arjun.oop.modifiers.inner.InnerA;

public class OuterB extends OuterA {
    public void modifyParentVariable(int newValue) {
        // no access since its private, need to use getters and setters
        // this.privateField;

        // can access since we are in same package
        this.defaultField = newValue;

        // the following will also work
        this.protectedField = newValue;
        this.publicField = newValue;
    }

    public void modifyInnerObject(int newValue) {
        InnerA innerA = new InnerA();

        // cannot access default because innerA never inherited it
        // innerA.defaultField = newValue;

        // important !!! : we are in same package as innerA
        // and protected is a subset of default
        // hence, we are able to access protected even
        // though we are not a subclass of OuterA
        innerA.protectedField = newValue;
        innerA.publicField = newValue;
    }

    public void modifyObjectVariable(int newValue) {
        Common common = new Common();

        // as long as we are in the same package
        // everything apart from private is accessible
        common.defaultField = newValue;
        common.protectedField = newValue;
        common.publicField = newValue;
    }
}

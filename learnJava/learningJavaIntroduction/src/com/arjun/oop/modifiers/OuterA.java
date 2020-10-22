package com.arjun.oop.modifiers;

public class OuterA {
    private int privateField;
    int defaultField;
    protected int protectedField;
    public int publicField;

    public int getPrivateField() {
        return privateField;
    }

    public void setPrivateField(int privateField) {
        this.privateField = privateField;
    }

    public int getDefaultField() {
        return defaultField;
    }

    public void setDefaultField(int defaultField) {
        this.defaultField = defaultField;
    }

    public int getProtectedField() {
        return protectedField;
    }

    public void setProtectedField(int protectedField) {
        this.protectedField = protectedField;
    }

    public int getPublicField() {
        return publicField;
    }

    public void setPublicField(int publicField) {
        this.publicField = publicField;
    }
}

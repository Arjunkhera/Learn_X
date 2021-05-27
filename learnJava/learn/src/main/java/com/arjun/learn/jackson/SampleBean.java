package com.arjun.learn.jackson;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Map;

@JsonRootName(value = "Wrapper")
public class SampleBean {
    public String firstName;
    public String lastName;

    private Map<String, String> flatMap;

    @JsonProperty("name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstNameName(String firstName) {
        this.firstName = firstName;
    }

    @JsonGetter("lastName")
    public String getLastNameMethod() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonAnyGetter
    public Map<String, String> getFlatMap() {
        return flatMap;
    }

    public void setFlatMap(Map<String, String> flatMap) {
        this.flatMap = flatMap;
    }
}

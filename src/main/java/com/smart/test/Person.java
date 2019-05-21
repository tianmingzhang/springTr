package com.smart.test;

import javax.validation.constraints.NotNull;

public class Person {

    @NotNull
    private String name;

    @NotNull
    private String testContent;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getTestContent() {
        return testContent;
    }

    public void setTestContent(String testContent) {
        this.testContent = testContent;
    }
}

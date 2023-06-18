package com.annotations.Spring_Boot_Annotations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    @JsonProperty("name")
    String name;

    public Student(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Student(String name){
        this.name = name;
    }
    public void studying(){
        System.out.println(this.name+" is studying..!");
    }
}

package com.example.oceanedu;

public class Animal {
    private String name;
    private String funFact;
    private String key;

    public Animal(){

    }

    public Animal(String key, String name, String funFact) {
        this.key = key;
        this.name = name;
        this.funFact = funFact;
    }

    public String getKey(){

        return key;
    }

    public void setKey(String key) {

        this.key = key;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getFunFact() {

        return funFact;
    }

    public void setFunFact(String funFact) {

        this.funFact = funFact;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", fun fact='" + funFact +
                '}';
    }
}

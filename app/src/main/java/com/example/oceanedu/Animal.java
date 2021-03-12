package com.example.oceanedu;

/**
 *
 */
public class Animal {
    private String name;
    private String funFact;
    private String key;

    /**
     *
     */
    public Animal(){

    }

    /**
     *
     * @param key
     * @param name
     * @param funFact
     */
    public Animal(String key, String name, String funFact) {
        this.key = key;
        this.name = name;
        this.funFact = funFact;
    }

    /**
     *
     * @return
     */
    public String getKey(){

        return key;
    }

    /**
     *
     * @param key
     */
    public void setKey(String key) {

        this.key = key;
    }

    /**
     *
     * @return
     */
    public String getName() {

        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getFunFact() {

        return funFact;
    }

    /**
     *
     * @param funFact
     */
    public void setFunFact(String funFact) {

        this.funFact = funFact;
    }
}

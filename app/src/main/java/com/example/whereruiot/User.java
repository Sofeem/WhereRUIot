package com.example.whereruiot;

import android.text.Editable;

public class User {
    private int ID;
    private String Name;
    private String Person1_name;
    private String Person2_name;

    public User(){}

    public User(int ID, String Name, String Person1_name,String Person2_name){

        this.ID=ID;
        this.Name=Name;
        this.Person1_name=Person1_name;
        this.Person2_name=Person2_name;
    }


    public int getId() { return ID; }
    public void setId(int id) { this.ID = id; }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getPerson1Name() {
        return Person1_name;
    }
    public void setPerson1Name(String Person1_name) {
        this.Person1_name = Person1_name;
    }
    public String getPerson2Name() {
        return Person2_name;
    }
    public void setPerson2Name(String Person2_name) {
        this.Person2_name = Person2_name;
    }
}
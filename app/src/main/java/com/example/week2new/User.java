package com.example.week2new;

public class User {
    public String name;
    public String getName(){
        return name;
    }
    public void setName(String newName){
        this.name = newName;
    }

    public String description;
    public String getDesc(){
        return description;
    }
    public void setDesc(String newDesc){
        this.description = newDesc;
    }

    public Integer id;
    public Integer getId(){
        return id;
    }
    public void setId(Integer newId){
        this.id = newId;
    }

    public Boolean followed;
    public Boolean getfollowed(){
        return followed;
    }
    public void setfollowed(Boolean newFollowed){
        this.followed = newFollowed;
    }
}


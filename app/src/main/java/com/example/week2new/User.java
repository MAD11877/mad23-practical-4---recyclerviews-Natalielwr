package com.example.week2new;

import java.util.UUID;

public class User {
    public String name;
    public String description;
    public String id;
    public Boolean followed;

    public User() {
        this.name = generateRandomName();
        this.description = generateDescription();
        this.id = generateUUID();
        this.followed = generateRandomBoolean();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public String getId() {
        return id;
    }
    public void setId(int id) {
        this.id = Integer.toString(id);
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public String generateRandomNumber(int digitsMin, int digitsMax) {
        int numDigits = (int) (Math.random() * (digitsMax - digitsMin + 1)) + digitsMin;
        StringBuilder sb = new StringBuilder(numDigits);
        for (int i = 0; i < numDigits; i++) {
            int digit = (int) (Math.random() * 10);
            sb.append(digit);
        }
        return sb.toString();
    }
    public String generateRandomName(){
        String prefix = "Name";
        String randomNumber = generateRandomNumber(9, 10);
        return prefix + randomNumber;
    }
    public String generateDescription(){
        return generateRandomNumber(9, 10);
    }

    public String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public boolean generateRandomBoolean() {
        return Math.random() < 0.5;
    }
}
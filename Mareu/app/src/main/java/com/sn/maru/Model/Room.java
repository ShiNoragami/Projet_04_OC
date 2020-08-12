package com.sn.maru.Model;

import androidx.annotation.NonNull;

public class Room {
    private String name;
    private String color;

    public Room(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
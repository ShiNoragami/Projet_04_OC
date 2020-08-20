package com.sn.maru.Model;

import androidx.annotation.NonNull;

public class Room {
    private String name;
    private Integer color;

    public Room(String name, Integer color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
package com.sn.maru.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Model object representing a Meeting
 */
public class Meeting implements Serializable {

    private String name;
    private Room room;
    private Date mDate;
    private List<String> mail;

    public Meeting(String name, Room room, Date date, List<String> mail) {
        this.name = name;
        this.room = room;
        this.mDate = date;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDate() {
        return mDate;
    }

    public String getDateFormated() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = sdf.format(mDate);
        return dateString;
    }

    public StringBuilder getTimeFormated() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String timeString = sdf.format(this.getDate());
        StringBuilder time = new StringBuilder(timeString);
        time.setCharAt(2, 'H');
        return time;
    }

    public List<String> getMail() {
        return mail;
    }

    public void setMail(List<String> mail) {
        this.mail = mail;
    }
}

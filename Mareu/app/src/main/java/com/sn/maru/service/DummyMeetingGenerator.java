package com.sn.maru.service;

import com.sn.maru.R;
import com.sn.maru.model.Meeting;
import com.sn.maru.model.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class DummyMeetingGenerator {
    public static List<Room> ROOM_LIST = Arrays.asList(
            new Room("Salle 1", R.color.colorPrimary),
            new Room("Salle 2", R.color.colorPrimaryDark),
            new Room("Salle 3", R.color.colorPrimary),
            new Room("Salle 4", R.color.colorPrimaryDark),
            new Room("Salle 5", R.color.colorPrimary),
            new Room("Salle 6", R.color.colorPrimaryDark),
            new Room("Salle 7", R.color.colorPrimary),
            new Room("Salle 8", R.color.colorPrimaryDark),
            new Room("Salle 9", R.color.colorPrimary),
            new Room("Salle 10", R.color.colorPrimaryDark)
    );

    public static List<Meeting> MEETINGS = Arrays.asList();

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(MEETINGS);
    }

    static List<Room> generateRooms() {
        return new ArrayList<>(ROOM_LIST);
    }

    /**
     * Fake Meeting Generator For Test
     */
    public static Calendar mCalendar = Calendar.getInstance();
    public static Date mDate = mCalendar.getTime();
    public static Date mDate2 = oneHourMoreToDate();

    public static Date oneHourMoreToDate() {
        mCalendar.add(Calendar.DATE, 2);
        mDate2 = mCalendar.getTime();
        return mDate2;
    }

    public static List<String> MAILS = Arrays.asList(
            "Mario@gmail.com",
            "Luigi@gmail.com",
            "peach@gmail.com"
    );
    public static List<Meeting> FAKE_MEETING = Arrays.asList(
            new Meeting("Réunion 1", ROOM_LIST.get(0), mDate, MAILS),
            new Meeting("Réunion 2", ROOM_LIST.get(1), mDate2, MAILS)
    );
}

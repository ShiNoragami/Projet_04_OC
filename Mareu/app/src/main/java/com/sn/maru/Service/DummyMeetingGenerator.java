package com.sn.maru.Service;

import com.sn.maru.Model.Meeting;
import com.sn.maru.Model.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyMeetingGenerator {
    public static List<Room> ROOM_LIST = Arrays.asList(
            new Room("Salle 1", "#00AEFF"),
            new Room("Salle 2", "#00FFAE"),
            new Room("Salle 3", "#00AEFF"),
            new Room("Salle 4", "#00FFAE"),
            new Room("Salle 5", "#00AEFF"),
            new Room("Salle 6", "#00FFAE"),
            new Room("Salle 7", "#00AEFF"),
            new Room("Salle 8", "#00FFAE"),
            new Room("Salle 9", "#00AEFF"),
            new Room("Salle 10", "#00FFAE")
    );

    public static List<Meeting> MEETINGS = Arrays.asList();

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(MEETINGS);
    }

    static List<Room> generateRooms() {
        return new ArrayList<>(ROOM_LIST);
    }
}

package com.sn.maru.service;

import com.sn.maru.model.Meeting;
import com.sn.maru.model.Room;

import java.util.List;

public interface MeetingApiService {

    List<Meeting> getMeetingList();

    void addMeeting(Meeting meeting);

    void deleteMeeting(Meeting meeting);

    List<Room> getRooms();

    List<Meeting> filterByDate(String date);

    List<Meeting> filterByPlace(String place);
}

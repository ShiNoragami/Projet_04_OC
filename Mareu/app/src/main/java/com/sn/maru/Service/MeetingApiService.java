package com.sn.maru.Service;

import com.sn.maru.Model.Meeting;
import com.sn.maru.Model.Room;

import java.util.List;

public interface MeetingApiService {

    List<Meeting> getMeetingList();

    void addMeeting(Meeting meeting);

    void deleteMeeting(Meeting meeting);

    List<Room> getRooms();
}

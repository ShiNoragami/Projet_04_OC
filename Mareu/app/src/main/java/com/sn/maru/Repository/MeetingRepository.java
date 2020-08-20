package com.sn.maru.Repository;

import com.sn.maru.Model.Meeting;
import com.sn.maru.Model.Room;
import com.sn.maru.Service.MeetingApiService;

import java.util.List;

public class MeetingRepository {

    private final MeetingApiService mMeetingApiService;

    public MeetingRepository(MeetingApiService meetingApiService) {
        mMeetingApiService = meetingApiService;
    }

    public List<Meeting> getMeetingsList() {
        List<Meeting> meetings = mMeetingApiService.getMeetingList();
        return meetings;
    }

    public void addMeeting(Meeting meeting) {
        mMeetingApiService.addMeeting(meeting);
    }

    public void deleteMeeting(Meeting meeting) {
        mMeetingApiService.deleteMeeting(meeting);
    }

    public List<Room> getMeetingsRoomsList() {
        List<Room> roomList = mMeetingApiService.getRooms();
        return roomList;
    }

    public List<Meeting> filterByDate(String date) {
        return mMeetingApiService.filterByDate(date);
    }

    public List<Meeting> filterByPlace(String place) {
        return mMeetingApiService.filterByPlace(place);
    }
}


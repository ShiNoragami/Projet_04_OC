package com.sn.maru.Service;

import com.sn.maru.Model.Meeting;
import com.sn.maru.Model.Room;

import java.util.ArrayList;
import java.util.List;

public class DummyMeetingApiService implements MeetingApiService {

    private List<Meeting> mMeetingList = DummyMeetingGenerator.generateMeetings();
    private List<Room> mRoomList = DummyMeetingGenerator.generateRooms();

    @Override
    public List<Meeting> getMeetingList() {
        return this.mMeetingList;
    }

    @Override
    public void addMeeting(Meeting meeting) {
        mMeetingList.add(meeting);
    }

    @Override
    public void deleteMeeting(Meeting meeting) {
        mMeetingList.remove(meeting);
    }

    @Override
    public List<Room> getRooms() {
        return this.mRoomList;
    }

    @Override
    public List<Meeting> filterByDate(String date) {
        List<Meeting> meetingListByDate = new ArrayList<>();
        for (Meeting meeting : mMeetingList) {
            if (meeting.getDateFormated().equals(date)) {
                meetingListByDate.add(meeting);
            }
        }
        return meetingListByDate;
    }

    @Override
    public List<Meeting> filterByPlace(String place) {
        List<Meeting> meetingListByPlace = new ArrayList<>();
        for (Meeting meeting : mMeetingList) {
            if (meeting.getRoom().toString() == place) {
                meetingListByPlace.add(meeting);
            }
        }
        return meetingListByPlace;
    }
}

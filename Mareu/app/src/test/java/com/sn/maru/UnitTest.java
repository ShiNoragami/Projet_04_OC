package com.sn.maru;

import com.sn.maru.model.Meeting;
import com.sn.maru.repository.MeetingRepository;
import com.sn.maru.service.DummyMeetingApiService;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.sn.maru.service.DummyMeetingGenerator.MAILS;
import static com.sn.maru.service.DummyMeetingGenerator.ROOM_LIST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UnitTest {

    private MeetingRepository mMeetingRepository;
    private List<Meeting> mMeetingList;
    private Calendar mCalendar = Calendar.getInstance();
    private Date currentTime = mCalendar.getTime();

    @Before
    public void setup() {
        mMeetingRepository = new MeetingRepository(new DummyMeetingApiService());
        mMeetingList = mMeetingRepository.getMeetingsList();
    }

    /**
     * Create and Add a meeting then check if List of meeting contains it.
     */
    @Test
    public void addMeetingWithSuccess() {
        Meeting mMeeting = new Meeting("Réunion Test", ROOM_LIST.get(1), currentTime, MAILS);
        mMeetingRepository.addMeeting(mMeeting);
        assertTrue(mMeetingList.contains(mMeeting));
    }

    /**
     * Create and Add a meeting, check if List of meeting contains it.
     * Then delete the meeting and check than is not contains anymore.
     */
    @Test
    public void deleteMeetingWithSuccess() {
        Meeting mMeeting = new Meeting("Réunion Test", ROOM_LIST.get(1), currentTime, MAILS);
        mMeetingRepository.addMeeting(mMeeting);
        assertTrue(mMeetingList.contains(mMeeting));
        mMeetingRepository.deleteMeeting(mMeeting);
        assertFalse(mMeetingList.contains(mMeeting));
    }


    /**
     * Filter list by place.
     * And check if meetings filtered have room expected.
     */
    @Test
    public void filterByPlaceMeeting() {
        String placeFilter = "Salle 1";//ROOM_LIST id = 0.
        Meeting m1 = new Meeting("Réunion Test", ROOM_LIST.get(0), currentTime, MAILS);
        Meeting m2 = new Meeting("Réunion Test", ROOM_LIST.get(5), currentTime, MAILS);
        Meeting m3 = new Meeting("Réunion Test", ROOM_LIST.get(2), currentTime, MAILS);
        mMeetingRepository.addMeeting(m1);
        mMeetingRepository.addMeeting(m2);
        mMeetingRepository.addMeeting(m3);

        List<Meeting> meetingList = mMeetingRepository.getMeetingsList();
        List<Meeting> meetingListFilter = mMeetingRepository.filterByPlace(placeFilter);

        assertEquals(3, meetingList.size());
        for (Meeting m : meetingListFilter) {
            assertEquals(m.getRoom().toString(), placeFilter);
        }
    }

    /**
     * Filter the list by Date, and return array of meetings.
     * then check if size list is equals and the meeting have correct date.
     */
    @Test
    public void filterByDateMeeting() {
        String dateFilter = "05/10/2020";
        //month in calendar is an array start to 0: November == 10.
        mCalendar.set(2020, 10, 15);
        Date date = mCalendar.getTime();
        mCalendar.set(2020, 11, 20);
        Date date1 = mCalendar.getTime();

        Meeting m1 = new Meeting("Réunion Test", ROOM_LIST.get(5), date, MAILS);
        Meeting m2 = new Meeting("Réunion Test", ROOM_LIST.get(8), date1, MAILS);
        Meeting m3 = new Meeting("Réunion Test", ROOM_LIST.get(2), date, MAILS);

        mMeetingRepository.addMeeting(m1);
        mMeetingRepository.addMeeting(m2);
        mMeetingRepository.addMeeting(m3);

        List<Meeting> meetingList = mMeetingRepository.getMeetingsList();
        List<Meeting> meetingListFilter = mMeetingRepository.filterByDate(dateFilter);

        assertEquals(3, meetingList.size());
        for (Meeting m : meetingListFilter) {
            assertEquals(m.getDateFormated(), dateFilter);
        }
    }
}

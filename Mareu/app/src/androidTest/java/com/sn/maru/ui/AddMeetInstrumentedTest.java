package com.sn.maru.ui;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.sn.maru.R;
import com.sn.maru.repository.MeetingRepository;
import com.sn.maru.service.DummyMeetingApiService;
import com.sn.maru.ui.meeting_list.mainactivity.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.sn.maru.utils.RecyclerViewItemCountAssertion.withItemCount;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AddMeetInstrumentedTest {

    public MeetingRepository mMeetingRepository;
    public int ITEM_COUNT;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup() {
        mMeetingRepository = new MeetingRepository(new DummyMeetingApiService());
        ITEM_COUNT = mMeetingRepository.getMeetingsList().size();
    }

    @Test
    public void addMeetingInstrumentedTest() {

        //click on button to add meeting
        onView(withId(R.id.add_meeting_fab)).perform(click());

        //add text in the editText for the meeting name
        onView(withId(R.id.create_meeting_subject_et)).perform(scrollTo(), replaceText("Test"), closeSoftKeyboard());

        //select the date of meeting in dialog
        onView(withId(R.id.date_selector_btn)).perform(click());

        //validate the date selected
        onView(withId(android.R.id.button1)).perform(scrollTo(), click());

        //select time of meeting
        onView(withId(R.id.time_selector_btn)).perform(click());

        //validate the time
        onView(withId(android.R.id.button1)).perform(scrollTo(), click());

        //Open the dialog to add one email adress of contributor
        onView(withId(R.id.contributor_selector_btn)).perform(scrollTo(), click());

        //add the email adress in edit text
        onView(withId(R.id.contributor_edit_txt)).perform(replaceText("peach@lamzon.com"), closeSoftKeyboard());

        //validate the choice
        onView(withId(android.R.id.button1)).perform(scrollTo(), click());

        //create the meeting on click on create button
        onView(withId(R.id.add_save)).perform(scrollTo(), click());

        //check if the meeting is add in recycler view
        onView(ViewMatchers.withId(R.id.meeting_recycler_view)).check(withItemCount(1));
    }
}
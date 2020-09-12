package com.sn.maru.ui;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.sn.maru.R;
import com.sn.maru.model.Meeting;
import com.sn.maru.ui.meeting_list.mainactivity.MainActivity;
import com.sn.maru.utils.DeleteAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static com.sn.maru.service.DummyMeetingGenerator.FAKE_MEETING;
import static com.sn.maru.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(AndroidJUnit4.class)
public class DeleteMeetInstrumentedTest {

    private MainActivity mActivity;
    private int ITEM_COUNT;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
        for (Meeting meeting : FAKE_MEETING) {
            mActivity.getMeetingRepository().addMeeting(meeting);
        }
        List<Meeting> meetingList = mActivity.getMeetingRepository().getMeetingsList();
        ITEM_COUNT = meetingList.size();
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void MeetingList_shouldNotBeEmpty() {
        onView(ViewMatchers.withId(R.id.meeting_recycler_view))
                .check(withItemCount(ITEM_COUNT));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void meetingList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position selected
        onView(ViewMatchers.withId(R.id.meeting_recycler_view)).check(withItemCount(ITEM_COUNT));
        // When perform a click on a delete icon
        onView(ViewMatchers.withId(R.id.meeting_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new DeleteAction()));
        // Then : the number of element have one less.
        onView(ViewMatchers.withId(R.id.meeting_recycler_view)).check(withItemCount(ITEM_COUNT - 1));
    }
}


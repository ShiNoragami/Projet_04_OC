package com.sn.maru.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.sn.maru.service.DummyMeetingApiService;
import com.sn.maru.service.MeetingApiService;
import com.sn.maru.R;
import com.sn.maru.repository.MeetingRepository;
import com.sn.maru.ui.meeting_list.mainactivity.MainActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.sn.maru.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AddMeetInstrumentedTest {

    public MeetingRepository mMeetingRepository;
    public int ITEM_COUNT;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

   /* @Before
    public void setup() {
        mMeetingRepository = new MeetingRepository(new DummyMeetingApiService());
        ITEM_COUNT = mMeetingRepository.getMeetingsList().size();
    }*/

    @Test
    public void addMeetingInstrumentedTest() {

        //click on button to add meeting
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.add_meeting_fab),
                        childAtPosition(
                                allOf(withId(R.id.activity_main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        floatingActionButton.perform(click());

        //add text in the editText for the meeting name
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.create_meeting_subject_et),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.create_meeting_fragment),
                                        0),
                                1)));
        appCompatEditText.perform(scrollTo(), replaceText("Test"), closeSoftKeyboard());

        //select the date of meeting in dialog
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.date_selector_btn), withText("Selectioner la date"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        4),
                                0)));
        appCompatButton.perform(scrollTo(), click());

        //validate the date selected
        ViewInteraction appCompatButton2 = onView(
                allOf(withId(android.R.id.button1), withText("ok"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        appCompatButton2.perform(scrollTo(), click());

        //select time of meeting
        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.time_selector_btn), withText("Selectioner l'heure"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        4),
                                1)));
        appCompatButton3.perform(scrollTo(), click());

        //validate the time
        ViewInteraction appCompatButton4 = onView(
                allOf(withId(android.R.id.button1), withText("ok"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        appCompatButton4.perform(scrollTo(), click());

        //Open the dialog to add one email adress of contributor
        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.contributor_selector_btn), withText("Ajouter des participants"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.create_meeting_fragment),
                                        0),
                                10)));
        appCompatButton5.perform(scrollTo(), click());

        //add the email adress in edit text
        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.contributor_edit_txt),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("peach@lamzon.com"), closeSoftKeyboard());

        //validate the choice
        ViewInteraction appCompatButton6 = onView(
                allOf(withId(android.R.id.button1), withText("Valider"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        appCompatButton6.perform(scrollTo(), click());

        //create the meeting on click on create button
        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.add_save), withText("Créer réunion"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        13),
                                1)));
        appCompatButton7.perform(scrollTo(), click());

        //check if the meeting is add in recycler view
        onView(ViewMatchers.withId(R.id.meeting_recycler_view)).check(withItemCount(1));
    }

    public static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
package com.sn.maru.ui.meeting_list.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sn.maru.base.BaseActivity;
import com.sn.maru.R;
import com.sn.maru.ui.meeting_list.addmeet.AddMeetActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.add_meeting_fab)
    FloatingActionButton add_meeting_fab;
    @BindView(R.id.activity_main_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
        configureFragment();
        configureToolbar();
        configureFABAddMeeting();
    }

    /**
     * Configure the fragment Meeting to show in main activity
     */
    private void configureFragment() {
        MeetFragment fragment = new MeetFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_main, fragment)
                .commit();
    }

    private void configureToolbar() {
        setSupportActionBar(toolbar);
    }

    /**
     * SetUp the FloatingActionButton to start new AddMeetActivity
     */
    private void configureFABAddMeeting() {
        add_meeting_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddMeetActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Get ressources menu to show in this activity.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

}

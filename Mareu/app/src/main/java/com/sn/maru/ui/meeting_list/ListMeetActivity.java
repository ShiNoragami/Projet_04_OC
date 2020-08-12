package com.sn.maru.ui.meeting_list;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sn.maru.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListMeetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_meet);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.add_meet)
    void addMeeting() {
        AddMeetFragment.navigate(this);
    }

}

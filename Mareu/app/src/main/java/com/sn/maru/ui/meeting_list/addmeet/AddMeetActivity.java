package com.sn.maru.ui.meeting_list.addmeet;

import android.os.Bundle;

import com.sn.maru.R;
import com.sn.maru.base.BaseActivity;

public class AddMeetActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meet);

        AddMeetFragment fragment = new AddMeetFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.create_activity_main_layout, fragment)
                .commit();
    }
}

package com.sn.maru.ui.meeting_list.addmeet;

import android.os.Bundle;

import com.sn.maru.base.BaseActivity;
import com.sn.maru.R;

public class AddMeetActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_meet);

        AddMeetFragment fragment = new AddMeetFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.create_activity_main_layout, fragment)
                .commit();
    }
}

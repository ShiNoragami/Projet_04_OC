package com.sn.maru.base;

import androidx.appcompat.app.AppCompatActivity;

import com.sn.maru.MareuApplication;
import com.sn.maru.repository.MeetingRepository;

public abstract class BaseActivity extends AppCompatActivity {
    public MeetingRepository getMeetingRepository() {
        return ((MareuApplication) getApplication()).getMeetingRepository();
    }
}

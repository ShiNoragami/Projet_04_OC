package com.sn.maru;

import android.app.Application;
import android.content.res.Configuration;

import com.sn.maru.di.DI;
import com.sn.maru.repository.MeetingRepository;

public class MareuApplication extends Application {

    private MeetingRepository mMeetingRepository;

    public MeetingRepository getMeetingRepository() {
        if (mMeetingRepository == null) {
            mMeetingRepository = DI.createMeetingRepository();
        }
        return mMeetingRepository;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.mMeetingRepository = null;
    }
}


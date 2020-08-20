package com.sn.maru;

import android.content.res.Configuration;

import com.sn.maru.DI.DI;
import com.sn.maru.Repository.MeetingRepository;

public class MainActivity {
    private MeetingRepository mMeetingRepository;

    public MeetingRepository getMeetingRepository() {
        if (mMeetingRepository == null){
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


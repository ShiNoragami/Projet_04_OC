package com.sn.maru.Base;

import com.sn.maru.MainActivity;
import com.sn.maru.Repository.MeetingRepository;

public abstract class BaseActivity {
    public MeetingRepository getMeetingRepository() {
        return ((MainActivity) getApplication()).getMeetingRepository();
    }
}

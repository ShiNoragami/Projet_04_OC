package com.sn.maru.di;

import com.sn.maru.repository.MeetingRepository;
import com.sn.maru.service.DummyMeetingApiService;

/**
 * Dependency injector to get instance of services
 */
public class DI {

    public static MeetingRepository createMeetingRepository() {
        return new MeetingRepository(new DummyMeetingApiService());
    }
}


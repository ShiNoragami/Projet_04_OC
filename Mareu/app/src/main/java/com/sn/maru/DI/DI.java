package com.sn.maru.DI;

import com.sn.maru.Repository.MeetingRepository;
import com.sn.maru.Service.MeetingApiService;

/**
 * Dependency injector to get instance of services
 */
public class DI {

    public static MeetingRepository createMeetingRepository() {
        return new MeetingRepository(new MeetingApiService());
    }
}


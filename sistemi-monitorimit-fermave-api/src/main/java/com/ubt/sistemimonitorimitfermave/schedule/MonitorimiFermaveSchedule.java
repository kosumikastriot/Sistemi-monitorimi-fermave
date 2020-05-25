package com.ubt.sistemimonitorimitfermave.schedule;

import com.ubt.sistemimonitorimitfermave.service.PajisjaService;
import com.ubt.sistemimonitorimitfermave.ws.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class MonitorimiFermaveSchedule {
    @Autowired
    private MessageManager messageManager;

    @Autowired
    private PajisjaService pajisjaService;

    @Scheduled(fixedDelay = 500)
    public void getPajisjet(){
        messageManager.sendMessagePajisjet(pajisjaService.getAll());
    }
}

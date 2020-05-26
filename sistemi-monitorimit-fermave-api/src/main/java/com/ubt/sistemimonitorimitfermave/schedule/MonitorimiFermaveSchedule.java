package com.ubt.sistemimonitorimitfermave.schedule;

import com.ubt.sistemimonitorimitfermave.service.PajisjaService;
import com.ubt.sistemimonitorimitfermave.service.SenzorLogService;
import com.ubt.sistemimonitorimitfermave.service.SenzoriService;
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

    @Autowired
    private SenzoriService senzoriService;

    @Autowired
    private SenzorLogService senzorLogService;

    @Scheduled(fixedDelay = 1000)
    public void getPajisjet(){
        messageManager.sendMessagePajisjet(pajisjaService.getAll());
    }

    @Scheduled(fixedDelay = 1000)
    public void getSenzors(){
        messageManager.sendMessageSenzorat(senzoriService.getAll());
    }

    @Scheduled(fixedDelay = 1000)
    public void getSenzorLog(){
        messageManager.sendMessageSenzoratLog(senzorLogService.getAll());
    }
}

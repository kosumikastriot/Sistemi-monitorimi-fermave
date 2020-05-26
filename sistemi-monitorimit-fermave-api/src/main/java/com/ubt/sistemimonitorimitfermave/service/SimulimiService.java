package com.ubt.sistemimonitorimitfermave.service;

import com.ubt.sistemimonitorimitfermave.schedule.SimulimiSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimulimiService {

    @Autowired
    SimulimiSchedule simulimiSchedule;

    public Object simuloTemeraturen(Boolean started, Double min, Double max) {

        if (started){
            simulimiSchedule.setMin(min);
            simulimiSchedule.setMax(max);
            simulimiSchedule.setStarted(started);
        }else {
            simulimiSchedule.setStarted(started);
        }

        return true;
    }
}

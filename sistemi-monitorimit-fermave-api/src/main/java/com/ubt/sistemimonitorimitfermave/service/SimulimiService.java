package com.ubt.sistemimonitorimitfermave.service;

import com.ubt.sistemimonitorimitfermave.schedule.SimulimiSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimulimiService {

    @Autowired
    SimulimiSchedule simulimiSchedule;

    public Boolean simuloTemeraturen(Double min, Double max) {
        simulimiSchedule.setMinHelpTemperatura(null);
        simulimiSchedule.setMinTemperatura(min);
        simulimiSchedule.setMaxTemperatura(max);

        return true;
    }

    public Boolean simuloLageshtiaAjrit(Double min,Double max){
        simulimiSchedule.setVleraLageshtiaAjritMax(max);
        simulimiSchedule.setVleraLageshtiaAjritMin(min);
        return true;
    }

    public Boolean simuloNdricimin(Double min, Double max){
        simulimiSchedule.setNdricimiHelper(null);
        simulimiSchedule.setNdricimiMax(max);
        simulimiSchedule.setNdricimiMin(min);

        return true;
    }

    public Boolean simuloAmbientin(Double min, Double max){
        simulimiSchedule.setAmbientiHelper(null);
        simulimiSchedule.setAmbientiMax(max);
        simulimiSchedule.setAmbientiMin(min);
        return true;
    }
}

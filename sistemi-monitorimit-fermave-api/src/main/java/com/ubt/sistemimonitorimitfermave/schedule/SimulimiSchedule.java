package com.ubt.sistemimonitorimitfermave.schedule;

import com.ubt.sistemimonitorimitfermave.data.DashboardDTO;
import com.ubt.sistemimonitorimitfermave.ws.MessageManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SimulimiSchedule {
    @Getter
    @Setter
    private Boolean started = true;

    @Getter
    @Setter
    private Double min;

    @Getter
    @Setter
    private Double max;


    @Autowired
    private MessageManager messageManager;

    @Scheduled(fixedDelay = 1000)
    public void getTemperaturaSimulimi(){
        if (started){
            Double test = Math.random() * 20;

            DashboardDTO dashboardDTO = new DashboardDTO();
            dashboardDTO.setTemperatura(test);

            messageManager.sendMessageDashboard(dashboardDTO);

        }
    }
}

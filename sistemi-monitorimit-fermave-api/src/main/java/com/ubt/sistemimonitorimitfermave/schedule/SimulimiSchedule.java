package com.ubt.sistemimonitorimitfermave.schedule;

import com.ubt.sistemimonitorimitfermave.data.DashboardDTO;
import com.ubt.sistemimonitorimitfermave.entity.Konfigurimi;
import com.ubt.sistemimonitorimitfermave.service.KonfigurimiService;
import com.ubt.sistemimonitorimitfermave.service.PajisjaService;
import com.ubt.sistemimonitorimitfermave.service.SenzorLogService;
import com.ubt.sistemimonitorimitfermave.ws.MessageManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SimulimiSchedule {

    DashboardDTO dashboardDTO = new DashboardDTO();

    @Getter
    @Setter
    private Boolean started = true;

    @Getter
    @Setter
    private Double minTemperatura = 20.0;

    @Getter
    @Setter
    private Double minHelpTemperatura;

    @Getter
    @Setter
    private Double ndricimiHelper;

    @Getter
    @Setter
    private Double ambientiHelper;

    @Getter
    @Setter
    private Double maxTemperatura = 50.0;

    @Getter
    @Setter
    private Double vleraLageshtiaAjritMax = 70.0;

    @Getter
    @Setter
    private Double vleraLageshtiaAjritMin = 30.0;

    @Getter
    @Setter
    private Double ndricimiMax = 70.0;

    @Getter
    @Setter
    private Double ndricimiMin = 30.0;

    @Getter
    @Setter
    private Double ambientiMax = 70.0;

    @Getter
    @Setter
    private Double ambientiMin = 30.0;

    @Autowired
    private MessageManager messageManager;

    @Autowired
    private SenzorLogService senzorLogService;

    @Autowired
    private KonfigurimiService konfigurimiService;

    @Autowired
    private PajisjaService pajisjaService;

    @Scheduled(fixedDelay = 1000)
    public void getTemperaturaSimulimi(){
        if (started){
            if (minHelpTemperatura == null){
                minHelpTemperatura = minTemperatura;
            }
            minHelpTemperatura += 0.2;
            senzorLogService.create(1l, minHelpTemperatura);
            dashboardDTO.setTemperatura(minHelpTemperatura);

            messageManager.sendMessageDashboard(dashboardDTO);
            Konfigurimi konfigurimi = konfigurimiService.getOne(1l);

            if (minHelpTemperatura <= konfigurimi.getVleraMax()-1 && minHelpTemperatura >= konfigurimi.getVleraMin()+1){
                pajisjaService.ndalo(2l);
                pajisjaService.ndalo(3l);
            } else if (minHelpTemperatura < konfigurimi.getVleraMin()){
                pajisjaService.aktivizo(3l);
                pajisjaService.ndalo(2l);
                minHelpTemperatura += 0.3;
            }else if (minHelpTemperatura >= (konfigurimi.getVleraMax() + konfigurimi.getVleraMin())/2){
                minHelpTemperatura -= 0.7;
                pajisjaService.aktivizo(2l);
                pajisjaService.ndalo(3l);
            }
        }

    }

    @Scheduled(fixedDelay = 1000)
    public void getNdricimiSimulimi(){
        if(started){
            if(ndricimiHelper == null){
                ndricimiHelper = ndricimiMin;
            }

            ndricimiHelper -=2;
            senzorLogService.create(3l,ndricimiHelper);

            dashboardDTO.setNdricimi(ndricimiHelper);
            messageManager.sendMessageDashboard(dashboardDTO);

            Konfigurimi konfigurimi = konfigurimiService.getOne(3l);

            if(ndricimiHelper > konfigurimi.getVleraMax()){
                pajisjaService.ndalo(4l);
                ndricimiHelper = -2.0;
            }else if(ndricimiHelper < konfigurimi.getVleraMin()){
                pajisjaService.aktivizo(4l);
                ndricimiHelper +=1.0;
            }

        }
    }

    @Scheduled(fixedDelay = 1000)
    public void getAmbientiSimulimi(){
        if(started){
            if(ambientiHelper == null){
                ambientiHelper = ambientiMin;
            }

            ambientiHelper -=2;
            senzorLogService.create(4l,ambientiHelper);

            dashboardDTO.setAmbienti(ambientiHelper);

            messageManager.sendMessageDashboard(dashboardDTO);

            Konfigurimi konfigurimi = konfigurimiService.getOne(4l);

            if(ambientiHelper > konfigurimi.getVleraMax()){
                pajisjaService.ndalo(1l);
                ambientiHelper = -2.0;
            }else if(ambientiHelper < konfigurimi.getVleraMin()){
                pajisjaService.aktivizo(1l);
                ambientiHelper +=1.0;
            }

        }
    }

    @Scheduled(fixedDelay = 3000)
    public void getLageshtiaAjritSimulimi(){
        if(started){
            Double vleraLageshtiaAjritRandom = getRandomInteger(vleraLageshtiaAjritMax,vleraLageshtiaAjritMin);
            dashboardDTO.setLageshtijaAjrit(vleraLageshtiaAjritRandom);
            senzorLogService.create(2l,vleraLageshtiaAjritRandom);
            messageManager.sendMessageDashboard(dashboardDTO);
        }

    }

    public Double getRandomInteger(Double maximum, Double minimum){
        return ((Double) (Math.random()*(maximum - minimum))) + minimum;
    }

}

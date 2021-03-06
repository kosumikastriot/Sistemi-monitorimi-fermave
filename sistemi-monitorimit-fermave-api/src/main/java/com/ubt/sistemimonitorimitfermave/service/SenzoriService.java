package com.ubt.sistemimonitorimitfermave.service;

import com.ubt.sistemimonitorimitfermave.data.SenzoriDTO;
import com.ubt.sistemimonitorimitfermave.entity.Senzor_Log;
import com.ubt.sistemimonitorimitfermave.entity.Senzori;
import com.ubt.sistemimonitorimitfermave.repository.SenzorLogRepository;
import com.ubt.sistemimonitorimitfermave.repository.SenzoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.management.Sensor;

import java.util.ArrayList;
import java.util.List;

@Service
public class SenzoriService {

    @Autowired
    private SenzoriRepository senzoriRepository;

    @Autowired
    private SenzorLogRepository senzorLogRepository;

    public List<SenzoriDTO> getAll(){
        List<SenzoriDTO> senzoriDTOS = null;

        try{
            senzoriDTOS = new ArrayList<>();
            List<Senzori> senzors = senzoriRepository.findAll();

            for (Senzori sensor : senzors ) {
                SenzoriDTO senzoriDTO = new SenzoriDTO();
                Senzor_Log senzor_log =  senzorLogRepository.findTopBySenzoriOrderByKohaDesc(sensor);
                senzoriDTO.setVleraFundit(senzor_log.getVlera());
                senzoriDTO.setId(sensor.getId());
                senzoriDTO.setEmri(sensor.getEmri());
                senzoriDTO.setStatus(sensor.getStatus());
                senzoriDTO.setTipi(sensor.getTipi());
                senzoriDTO.setZona(sensor.getZona());

                senzoriDTOS.add(senzoriDTO);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return senzoriDTOS;
    }
}

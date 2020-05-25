package com.ubt.sistemimonitorimitfermave.service;

import com.ubt.sistemimonitorimitfermave.data.PajisjaDTO;
import com.ubt.sistemimonitorimitfermave.data.SenzorLogDTO;
import com.ubt.sistemimonitorimitfermave.entity.Pajisja;
import com.ubt.sistemimonitorimitfermave.entity.Senzor_Log;
import com.ubt.sistemimonitorimitfermave.repository.SenzorLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SenzorLogService {

    @Autowired
    private SenzorLogRepository senzorLogRepository;

    public List<SenzorLogDTO> getAll(){
        List<SenzorLogDTO> senzorLogDTOS = null;

        try{
            senzorLogDTOS = new ArrayList<>();
            List<Senzor_Log> senzor_logs = senzorLogRepository.findAll();

            for(Senzor_Log senzor_log : senzor_logs){
                SenzorLogDTO senzorLogDTO = new SenzorLogDTO();

                senzorLogDTO.setId(senzor_log.getId());
                senzorLogDTO.setKoha(senzor_log.getKoha());
                senzorLogDTO.setSenzori(senzor_log.getSenzori());
                senzorLogDTO.setVlera(senzor_log.getVlera());

                senzorLogDTOS.add(senzorLogDTO);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return senzorLogDTOS;
    }
}

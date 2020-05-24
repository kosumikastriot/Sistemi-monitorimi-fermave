package com.ubt.sistemimonitorimitfermave.service;

import com.ubt.sistemimonitorimitfermave.data.KonfigurimiDTO;
import com.ubt.sistemimonitorimitfermave.entity.Konfigurimi;
import com.ubt.sistemimonitorimitfermave.repository.KonfigurimiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KonfigurimiService {

    @Autowired
    private KonfigurimiRepository konfigurimiRepository;

    public List<KonfigurimiDTO> getAll(){
        List<KonfigurimiDTO> konfigurimiDTOS = null;
        try {
            konfigurimiDTOS = new ArrayList<>();
            List<Konfigurimi> konfigurimis = konfigurimiRepository.findAll();

            for (Konfigurimi konfigurimi : konfigurimis){
                KonfigurimiDTO konfigurimiDTO = new KonfigurimiDTO();

                konfigurimiDTO.setEmri(konfigurimi.getEmri());
                konfigurimiDTO.setId(konfigurimi.getId());
                konfigurimiDTO.setVleraMax(konfigurimi.getVleraMax());
                konfigurimiDTO.setVleraMin(konfigurimi.getVleraMin());

                konfigurimiDTOS.add(konfigurimiDTO);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return konfigurimiDTOS;
    }


}

package com.ubt.sistemimonitorimitfermave.service;

import com.ubt.sistemimonitorimitfermave.data.PajisjaDTO;
import com.ubt.sistemimonitorimitfermave.entity.Pajisja;
import com.ubt.sistemimonitorimitfermave.repository.PajisjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PajisjaService {

    @Autowired
    private PajisjaRepository pajisjaRepository;

    public List<PajisjaDTO> getAll(){
        List<PajisjaDTO> pajisjaDTOS = null;

        try{
            pajisjaDTOS = new ArrayList<>();
            List<Pajisja> pajisjas = pajisjaRepository.findAll();

            for (Pajisja pajisja : pajisjas ) {
                PajisjaDTO pajisjaDTO = new PajisjaDTO();

                pajisjaDTO.setId(pajisja.getId());
                pajisjaDTO.setEmri(pajisja.getEmri());
                pajisjaDTO.setFoto(pajisja.getFoto());
                pajisjaDTO.setStatus(pajisja.getStatus());
                pajisjaDTO.setZona(pajisja.getZona());

                pajisjaDTOS.add(pajisjaDTO);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return pajisjaDTOS;
    }
}

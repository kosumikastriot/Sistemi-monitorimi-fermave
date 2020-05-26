package com.ubt.sistemimonitorimitfermave.service;

import com.ubt.sistemimonitorimitfermave.data.PajisjaDTO;
import com.ubt.sistemimonitorimitfermave.entity.Pajisja;
import com.ubt.sistemimonitorimitfermave.entity.type.Status;
import com.ubt.sistemimonitorimitfermave.repository.PajisjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public PajisjaDTO getOne(Long id){
        PajisjaDTO pajisjaDTO = new PajisjaDTO();
        try {
            Pajisja pajisja = pajisjaRepository.getOne(id);

            pajisjaDTO.setId(pajisja.getId());
            pajisjaDTO.setEmri(pajisja.getEmri());

        }catch (Exception e){
            e.printStackTrace();
        }
        return pajisjaDTO;
    }

    public Boolean aktivizo(Long id){
        try {
            Optional<Pajisja> optionalPajisja = pajisjaRepository.findById(id);
            Pajisja pajisja = null;
            if (optionalPajisja.isPresent()){
                pajisja = optionalPajisja.get();
            }
            pajisja.setStatus(Status.ACTIVE);

            pajisjaRepository.save(pajisja);

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean ndalo(Long id){
        try {
            Optional<Pajisja> optionalPajisja = pajisjaRepository.findById(id);
            Pajisja pajisja = null;
            if (optionalPajisja.isPresent()){
                pajisja = optionalPajisja.get();
            }
            pajisja.setStatus(Status.INACTIVE);

            pajisjaRepository.save(pajisja);

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

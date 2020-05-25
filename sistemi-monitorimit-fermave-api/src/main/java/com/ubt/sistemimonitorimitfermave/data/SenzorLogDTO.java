package com.ubt.sistemimonitorimitfermave.data;

import com.ubt.sistemimonitorimitfermave.entity.Senzori;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SenzorLogDTO {
    private Long id;
    private Senzori senzori;
    private Double vlera;
    private Date koha;
}

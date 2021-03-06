package com.ubt.sistemimonitorimitfermave.data;

import com.ubt.sistemimonitorimitfermave.entity.Zona;
import com.ubt.sistemimonitorimitfermave.entity.type.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SenzoriDTO {
    private Long id;
    private String emri;
    private String tipi;
    private Zona zona;
    private Status status;
    private Double vleraFundit;

}

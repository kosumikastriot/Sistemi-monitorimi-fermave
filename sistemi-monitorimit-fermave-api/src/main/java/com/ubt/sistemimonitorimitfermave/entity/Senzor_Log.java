package com.ubt.sistemimonitorimitfermave.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Senzor_Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Senzori.class)
    @JoinColumn(name = "senzori_id", referencedColumnName = "id", nullable = false)
    private Senzori senzori;

    private Double vlera;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date koha;
}

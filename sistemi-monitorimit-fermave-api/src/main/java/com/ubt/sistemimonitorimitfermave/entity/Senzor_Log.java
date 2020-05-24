package com.ubt.sistemimonitorimitfermave.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    private LocalDateTime koha;
}

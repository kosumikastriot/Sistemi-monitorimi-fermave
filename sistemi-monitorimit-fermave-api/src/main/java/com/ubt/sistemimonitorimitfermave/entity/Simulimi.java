package com.ubt.sistemimonitorimitfermave.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Simulimi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double vleraMin;

    private Double vleraMax;

    @OneToOne(targetEntity = Senzori.class)
    @JoinColumn(name = "senzori_id", referencedColumnName = "id", nullable = false)
    private Senzori senzori;

    @ManyToOne(targetEntity = Zona.class)
    @JoinColumn(name = "zona_id", referencedColumnName = "id", nullable = false)
    private Zona zona;

}

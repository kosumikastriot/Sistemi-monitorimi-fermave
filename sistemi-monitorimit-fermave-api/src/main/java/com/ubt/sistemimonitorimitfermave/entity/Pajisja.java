package com.ubt.sistemimonitorimitfermave.entity;

import com.ubt.sistemimonitorimitfermave.entity.type.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Pajisja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emri;

    @Column(name = "foto", columnDefinition = "LONGTEXT", nullable = true)
    private String foto;

    @ManyToOne(targetEntity = Zona.class)
    @JoinColumn(name = "zona_id", referencedColumnName = "id", nullable = false)
    private Zona zona;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('ACTIVE','INACTIVE')", nullable = false)
    private Status status;

}

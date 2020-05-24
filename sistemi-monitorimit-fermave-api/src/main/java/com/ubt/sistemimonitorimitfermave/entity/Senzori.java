package com.ubt.sistemimonitorimitfermave.entity;

import com.ubt.sistemimonitorimitfermave.entity.type.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Senzori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emri;

    private String tipi;

    @ManyToOne(targetEntity = Zona.class)
    @JoinColumn(name = "zona_id", referencedColumnName = "id", nullable = false)
    private Zona zona;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('ACTIVE','INACTIVE')", nullable = false)
    private Status status;
}

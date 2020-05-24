package com.ubt.sistemimonitorimitfermave.entity;

import com.ubt.sistemimonitorimitfermave.entity.type.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Pajsija_Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Pajisja.class)
    @JoinColumn(name = "pajisja_id", referencedColumnName = "id", nullable = false)
    private Pajisja pajisja;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('ACTIVE','INACTIVE')", nullable = false)
    private Status status;

    private LocalDateTime koha;
}

package com.universidad.academico.Repository.entidadesDocumentos;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "matriculas")
@Data
public class MatriculaEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double feed;
    @JoinColumn(name = "estudiante_id")
    @OneToOne(fetch = FetchType.LAZY)
    private EstudianteEntity estudiante;
}

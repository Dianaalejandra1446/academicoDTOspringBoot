package com.universidad.academico.Repository.entidadesDocumentos;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "estudiante")
@Data
public class EstudianteEntity implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToOne(mappedBy = "estudiante",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MatriculaEntity matricula;
    
    @JoinColumn(name = "universidad_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UniversidadEntity universidad;
}

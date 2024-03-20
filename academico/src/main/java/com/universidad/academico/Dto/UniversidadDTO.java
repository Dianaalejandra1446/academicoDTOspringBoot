package com.universidad.academico.Dto;

import java.util.List;

import lombok.Data;

@Data
public class UniversidadDTO {
    private Long id;
    private String nombre;
    List<EstudianteDTO> estudiantes;
}

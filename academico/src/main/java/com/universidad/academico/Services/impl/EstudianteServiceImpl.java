package com.universidad.academico.Services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidad.academico.Configuracion.EstudianteDTOConverte;
import com.universidad.academico.Dto.EstudianteDTO;
import com.universidad.academico.Repository.EstudianteRepository;
import com.universidad.academico.Repository.entidadesDocumentos.EstudianteEntity;
import com.universidad.academico.Services.EstudianteServices;

import jakarta.transaction.Transactional;

@Service
public class EstudianteServiceImpl implements EstudianteServices {
    @Autowired // Anotación que indica que el contenedor de Spring debe inyectar una instancia de EstudianteRepository en este campo
    private EstudianteRepository estudianteRepository;
    
    @Autowired // Anotación que indica que el contenedor de Spring debe inyectar una instancia de EstudianteDTOConverte en este campo
    private EstudianteDTOConverte convert;
    
    @Override // Anotación para indicar que este método sobrescribe un método de la clase padre
    @Transactional // Anotación que indica que esta operación debe ser realizada dentro de una transacción
    public List<EstudianteDTO> finAll() {
        // Se obtienen todas las entidades de estudiantes de la base de datos a través del repositorio de estudiantes
        List<EstudianteEntity> estudianteEntities = (List<EstudianteEntity>) estudianteRepository.findAll();
        
        List<EstudianteDTO> estudianteDTO = new ArrayList<>(); //  Creamos una lista para almacenar los objetos EstudianteDTO
    
        // Se itera sobre cada entidad de estudiante y se convierte a EstudianteDTO utilizando el objeto convert de tipo EstudianteDTOConverte
        for (EstudianteEntity estudiante : estudianteEntities) {
            estudianteDTO.add(convert.converEstudianteDTO(estudiante)); // Se agrega el EstudianteDTO convertido a la lista
        }
    
        return estudianteDTO; // Se devuelve la lista de EstudianteDTO
    }
    
}

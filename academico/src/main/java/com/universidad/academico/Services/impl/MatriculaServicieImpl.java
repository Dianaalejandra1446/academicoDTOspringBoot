package com.universidad.academico.Services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.universidad.academico.Configuracion.MatriculaDTOConverte;
import com.universidad.academico.Dto.MatriculaDTO;
import com.universidad.academico.Repository.EstudianteRepository;
import com.universidad.academico.Repository.MatriculasRepository;
import com.universidad.academico.Repository.entidadesDocumentos.EstudianteEntity;
import com.universidad.academico.Repository.entidadesDocumentos.MatriculaEntity;
import com.universidad.academico.Services.MatriculaServices;

@Service
public class MatriculaServicieImpl implements MatriculaServices {

    @Autowired
    // Traemos el repository de matriculas
    private MatriculasRepository matriculasRepository;

    @Autowired
    // Traemos de repository de estudiante
    private EstudianteRepository estudianteRepository;

    @Autowired
    // Traemos la MatriculaDTO
    private MatriculaDTOConverte convert;

    @Override
    @Transactional
    public MatriculaDTO save(MatriculaDTO matricula) {
        Optional<EstudianteEntity> estudianteOptional = estudianteRepository.findById(matricula.getEstudianteId());

        if (estudianteOptional.isPresent()) {
            // Aca convertimos en entity a DTO si hay datos encontrados
            MatriculaEntity matriculaEntity = convert.converMatriculaEntity(matricula);
            matriculaEntity.setEstudiante(estudianteOptional.get());
            matriculasRepository.save(matriculaEntity);
            // Devolvemos la matricula convertida en DTO
            return convert.conveMatriculaDTO(matriculaEntity);
        }
        return null;
    }

    @Override // Anotación para indicar que este método sobrescribe un método de la clase padre
    @Transactional(readOnly = true) // Anotación que indica que esta operación es de solo lectura y debe estar dentro de una transacción
    // Traer todos los datos
    public List<MatriculaDTO> findAll() {
        // Se obtienen todas las matrículas de la base de datos a través del repositorio de matrículas
        List<MatriculaEntity> matriculasEntity = (List<MatriculaEntity>) matriculasRepository.findAll();
        
        // Se convierten las matrículas de tipo MatriculaEntity a MatriculaDTO utilizando una expresión lambda
        // y se mapean utilizando el objeto convert de tipo MatriculaDTOConverte
        // Finalmente, se recopilan en una lista de MatriculaDTO utilizando el método collect del stream
        return matriculasEntity.stream()
                                .map(matricula -> convert.conveMatriculaDTO(matricula))
                                .collect(Collectors.toList());
    }
    
}


package com.universidad.academico.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.universidad.academico.Dto.EstudianteDTO;
import com.universidad.academico.Repository.entidadesDocumentos.EstudianteEntity;

@Component
public class EstudianteDTOConverte {
    private ModelMapper dbm;

    public EstudianteDTO converEstudianteDTO(EstudianteEntity estudiante){
        EstudianteDTO estudianteDTO=dbm.map(estudiante, EstudianteDTO.class);
        if (estudiante.getMatricula()!=null) {
            estudianteDTO.setMatriculaId(estudiante.getMatricula().getId());
        }
        estudianteDTO.setUniversidadId(estudiante.getUniversidad().getId());
        return estudianteDTO;

    }
    public EstudianteEntity converEstudianteEntity(EstudianteDTO estudianteDTO){
        return dbm.map(estudianteDTO,EstudianteEntity.class);
    }
}

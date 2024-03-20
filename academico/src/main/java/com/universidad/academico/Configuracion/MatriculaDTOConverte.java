package com.universidad.academico.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.universidad.academico.Dto.MatriculaDTO;
import com.universidad.academico.Repository.entidadesDocumentos.MatriculaEntity;

@Component
public class MatriculaDTOConverte {
    @Autowired
    private ModelMapper dbm;

    public MatriculaDTO conveMatriculaDTO(MatriculaEntity matricula){

        MatriculaDTO matriculaDTO = dbm.map(matricula, MatriculaDTO.class);
        matriculaDTO.setEstudianteId(matricula.getId());
        return matriculaDTO;
    }

    public MatriculaEntity converMatriculaEntity(MatriculaDTO matriculaDTO){
        return dbm.map(matriculaDTO, MatriculaEntity.class);
    }
}

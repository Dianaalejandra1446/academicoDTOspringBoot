package com.universidad.academico.Services;

import java.util.List;

import com.universidad.academico.Dto.MatriculaDTO;
import com.universidad.academico.Repository.entidadesDocumentos.MatriculaEntity;

public interface MatriculaServices {
    MatriculaDTO save(MatriculaDTO matricula);

    List<MatriculaDTO> findAll();
}

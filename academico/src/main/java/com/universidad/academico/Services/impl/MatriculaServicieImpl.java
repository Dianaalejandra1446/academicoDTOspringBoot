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
    private MatriculasRepository matriculasRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private MatriculaDTOConverte convert;

    @Override
    @Transactional
    public MatriculaDTO save(MatriculaDTO matricula) {
        Optional<EstudianteEntity> estudianteOptional = estudianteRepository.findById(matricula.getEstudianteId());

        if (estudianteOptional.isPresent()) {
            MatriculaEntity matriculaEntity = convert.converMatriculaEntity(matricula);
            matriculaEntity.setEstudiante(estudianteOptional.get());
            matriculasRepository.save(matriculaEntity);
            return convert.conveMatriculaDTO(matriculaEntity);
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MatriculaDTO> findAll() {
        List<MatriculaEntity> matriculasEntity = (List<MatriculaEntity>) matriculasRepository.findAll();
        return matriculasEntity.stream()
                                .map(matricula -> convert.conveMatriculaDTO(matricula))
                                .collect(Collectors.toList());
    }
}


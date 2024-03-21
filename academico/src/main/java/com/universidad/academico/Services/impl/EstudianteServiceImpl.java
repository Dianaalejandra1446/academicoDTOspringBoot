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
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private EstudianteDTOConverte convert;

    @Override
    @Transactional
    public List<EstudianteDTO> finAll() {
        List<EstudianteEntity> estudianteEntities= (List<EstudianteEntity>) estudianteRepository.findAll();
        List<EstudianteDTO> estudianteDTO=new ArrayList<>();

            for (EstudianteEntity estudiante : estudianteEntities) {
                estudianteDTO.add(convert.converEstudianteDTO(estudiante));
            }
            return estudianteDTO;
    }
    
}

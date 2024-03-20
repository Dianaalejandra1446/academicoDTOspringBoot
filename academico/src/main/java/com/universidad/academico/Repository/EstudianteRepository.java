package com.universidad.academico.Repository;

import org.springframework.data.repository.CrudRepository;

import com.universidad.academico.Repository.entidadesDocumentos.EstudianteEntity;

public interface EstudianteRepository extends CrudRepository<EstudianteEntity,Long>{
    
}

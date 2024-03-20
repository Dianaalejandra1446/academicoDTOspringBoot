package com.universidad.academico.Repository;

import org.springframework.data.repository.CrudRepository;

import com.universidad.academico.Repository.entidadesDocumentos.MatriculaEntity;

public interface MatriculasRepository extends CrudRepository<MatriculaEntity,Long>{

    
}
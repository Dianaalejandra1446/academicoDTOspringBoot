// Indica el paquete al que pertenece esta clase
package com.universidad.academico.Configuracion;

// Importa las clases necesarias
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.universidad.academico.Dto.MatriculaDTO;
import com.universidad.academico.Repository.entidadesDocumentos.MatriculaEntity;

// Indica que esta clase es un componente de Spring y será administrada por el contenedor de Spring
@Component
public class MatriculaDTOConverte {
    @Autowired // Inyección de dependencia de Spring que proporciona una instancia de ModelMapper
    private ModelMapper dbm; // Instancia de ModelMapper para realizar las conversiones

    // Método para convertir una MatriculaEntity a MatriculaDTO
    public MatriculaDTO conveMatriculaDTO(MatriculaEntity matricula) {
        MatriculaDTO matriculaDTO = dbm.map(matricula, MatriculaDTO.class); // Mapea los campos de matricula a matriculaDTO
        matriculaDTO.setEstudianteId(matricula.getId()); // Establece el ID del estudiante en el DTO
        return matriculaDTO; // Devuelve el objeto MatriculaDTO convertido
    }

    // Método para convertir una MatriculaDTO a MatriculaEntity
    public MatriculaEntity converMatriculaEntity(MatriculaDTO matriculaDTO) {
        return dbm.map(matriculaDTO, MatriculaEntity.class); // Mapea los campos de matriculaDTO a MatriculaEntity y devuelve el resultado
    }
}

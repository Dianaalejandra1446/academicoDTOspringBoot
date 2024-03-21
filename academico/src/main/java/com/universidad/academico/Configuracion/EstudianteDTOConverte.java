// Indica el paquete al que pertenece esta clase
package com.universidad.academico.Configuracion;

// Importa las clases necesarias
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.universidad.academico.Dto.EstudianteDTO;
import com.universidad.academico.Repository.entidadesDocumentos.EstudianteEntity;

// Indica que esta clase es un componente de Spring y será administrada por el contenedor de Spring
@Component
public class EstudianteDTOConverte {
    private ModelMapper dbm; // Instancia de ModelMapper para realizar las conversiones

    // Método para convertir un EstudianteEntity a EstudianteDTO
    public EstudianteDTO converEstudianteDTO(EstudianteEntity estudiante) {
        EstudianteDTO estudianteDTO = dbm.map(estudiante, EstudianteDTO.class); // Mapea los campos de estudiante a estudianteDTO
        if (estudiante.getMatricula() != null) {
            estudianteDTO.setMatriculaId(estudiante.getMatricula().getId()); // Si hay una matrícula asociada, establece su ID en el DTO
        }
        estudianteDTO.setUniversidadId(estudiante.getUniversidad().getId()); // Establece el ID de la universidad en el DTO
        return estudianteDTO; // Devuelve el objeto EstudianteDTO convertido
    }

    // Método para convertir un EstudianteDTO a EstudianteEntity
    public EstudianteEntity converEstudianteEntity(EstudianteDTO estudianteDTO) {
        return dbm.map(estudianteDTO, EstudianteEntity.class); // Mapea los campos de estudianteDTO a EstudianteEntity y devuelve el resultado
    }
}

package com.universidad.academico.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universidad.academico.Dto.EstudianteDTO;
import com.universidad.academico.Services.EstudianteServices;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteServices estudianteServices;


    @GetMapping("/")
    public List<EstudianteDTO> findAll(){
        return estudianteServices.finAll();
    }
}

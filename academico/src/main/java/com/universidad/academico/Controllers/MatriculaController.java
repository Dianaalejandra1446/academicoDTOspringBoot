package com.universidad.academico.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universidad.academico.Dto.MatriculaDTO;
import com.universidad.academico.Services.MatriculaServices;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    @Autowired
    private MatriculaServices matriculaServices;   


      @GetMapping("/")
      public List<MatriculaDTO> findAll(){
         return matriculaServices.findAll();
      }


      @PostMapping("/")
      public MatriculaDTO save(@RequestBody MatriculaDTO matricula){
           return matriculaServices.save(matricula);

      }    
}

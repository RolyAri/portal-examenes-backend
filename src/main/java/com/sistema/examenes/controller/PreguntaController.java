package com.sistema.examenes.controller;

import com.sistema.examenes.entities.Examen;
import com.sistema.examenes.entities.Pregunta;
import com.sistema.examenes.services.ExamenService;
import com.sistema.examenes.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/pregunta")
@CrossOrigin("*")
public class PreguntaController {
    @Autowired
    private PreguntaService preguntaService;
    @Autowired
    private ExamenService examenService;
    @PostMapping("/")
    public ResponseEntity<?> guardarPregunta(@RequestBody Pregunta pregunta){
        return ResponseEntity.ok(preguntaService.agregarPregunta(pregunta));
    }
    @PutMapping("")
    public ResponseEntity<?> actualizarPregunta(@RequestBody Pregunta pregunta){
        return ResponseEntity.ok(preguntaService.actualizarPregunta(pregunta));
    }
    @GetMapping("/examen/{examenId}")
    public ResponseEntity<?> listarPreguntasDelExamen(@PathVariable("examenId") Long examenId){
        Examen examen = examenService.obtenerExamen(examenId);
        Set<Pregunta> preguntas = examen.getPreguntas();
        List examenes = new ArrayList(preguntas);
        if (examenes.size()>Integer.parseInt(examen.getNumeroDePreguntas())){
            examenes = examenes.subList(0,Integer.parseInt((examen.getNumeroDePreguntas()+1)));
        }
        Collections.shuffle(examenes);
        return ResponseEntity.ok(examen.getPreguntas());
    }
    @GetMapping("/{preguntaId}")
    public Pregunta listarPreguntaPorId(@PathVariable("preguntaId") Long preguntaId) {
        return preguntaService.obtenerPregunta(preguntaId);
    }
    @DeleteMapping("/{preguntaId}")
    public void eliminarPregunta(@PathVariable("preguntaId") Long preguntaId){
        preguntaService.eliminarPregunta(preguntaId);
    }
}

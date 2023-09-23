package com.sistema.examenes.controller;

import com.sistema.examenes.entities.Examen;
import com.sistema.examenes.services.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/examen")
@CrossOrigin()
public class ExamenController {
    @Autowired
    ExamenService examenService;
    @PostMapping("/")
    public ResponseEntity<Examen> guardarExamen(@RequestBody Examen examen){
        return ResponseEntity.ok(examenService.agregarExamen(examen));
    }
    @PutMapping("/")
    public ResponseEntity<Examen> actualizarExamen(@RequestBody Examen examen) {
        return ResponseEntity.ok(examenService.actualizarExamen(examen));
    }
    @GetMapping("/")
    public ResponseEntity<?> listarExamenes(){
        return ResponseEntity.ok(examenService.obtenerExamenes());
    }
    @GetMapping("/{examenId}")
    public Examen obtenerExamen(@PathVariable("examenId") Long examenId){
        return examenService.obtenerExamen(examenId);
    }
    @DeleteMapping("/{examenId}")
    public void EliminarExamen(@PathVariable("examenId") Long examenId){
        examenService.eliminarExamen(examenId);
    }
}

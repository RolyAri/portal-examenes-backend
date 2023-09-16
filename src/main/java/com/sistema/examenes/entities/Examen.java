package com.sistema.examenes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "examenes")
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examenId;
    private String titulo;
    private String description;
    private String puntosMaximos;
    private String numeroDePreguntas;
    private boolean activo = false;
    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;
    @OneToMany(mappedBy = "examen", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Pregunta> preguntas = new HashSet<>();
}

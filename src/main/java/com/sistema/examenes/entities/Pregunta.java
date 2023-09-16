package com.sistema.examenes.entities;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;

@Entity
@Data
@Table(name = "preguntas")
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preguntaID;
    @Column(length = 5000)
    private String contenido;
    private String imagen;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    @ManyToOne(fetch = FetchType.EAGER)
    private Examen examen;
}

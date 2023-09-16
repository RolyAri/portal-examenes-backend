package com.sistema.examenes.services;

import com.sistema.examenes.entities.Categoria;

import java.util.Set;

public interface CategoriaService {
    Categoria agregarCategoria(Categoria categoria);
    Categoria actualizarCategoria(Categoria categoria);
    Set<Categoria> obtenerCategorias();
    Categoria obtenerCategoria(Long categoriaId);
    void elimarCategoria(Long categoriaId);
}

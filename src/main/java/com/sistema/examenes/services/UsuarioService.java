package com.sistema.examenes.services;

import com.sistema.examenes.entities.Usuario;
import com.sistema.examenes.entities.UsuarioRol;
import com.sistema.examenes.repository.UsuarioRepository;

import java.util.Set;

public interface UsuarioService {
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;
    public Usuario obtenerUsuario(String username);
    public void eliminarUsuario(Long usuarioId);
}

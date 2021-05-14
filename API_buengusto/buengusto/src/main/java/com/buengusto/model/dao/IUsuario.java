package com.buengusto.model.dao;

import com.buengusto.model.dto.LoginDTO;
import com.buengusto.model.dto.UsuarioDTO;
import com.buengusto.model.dto.UsuarioModificarDTO;
import com.buengusto.model.entity.Usuario;

public interface IUsuario {

    void crear(UsuarioDTO usuarioDTO) throws Exception;
    void actualizar(UsuarioModificarDTO usuarioModificarDTO) throws Exception;
    void eliminar(String usuario) throws Exception;
    boolean buscar(String usario) throws Exception;
    UsuarioDTO buscarInformacion(LoginDTO loginDTO) throws Exception;
    int buscarId(String usuario) throws Exception;
}

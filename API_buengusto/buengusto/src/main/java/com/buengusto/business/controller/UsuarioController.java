package com.buengusto.business.controller;

import com.buengusto.model.dao.CarritoImpl;
import com.buengusto.model.dao.ICarrito;
import com.buengusto.model.dao.UsuarioImpl;
import com.buengusto.model.dto.LoginDTO;
import com.buengusto.model.dto.UsuarioDTO;
import com.buengusto.model.dto.UsuarioModificarDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,
        RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController {

    @GetMapping("/{usuario}")
    public ResponseEntity<Boolean> buscarUsuario(@PathVariable("usuario") String usuario) throws Exception {
        Boolean respuesta= new UsuarioImpl().buscar(usuario);
        return new ResponseEntity<Boolean>(respuesta,HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<UsuarioDTO> loginUsuario(@RequestBody LoginDTO loginDTO) throws Exception {
        UsuarioDTO respuesta=null;
        if(new UsuarioImpl().buscar(loginDTO.getUsuario())){
            respuesta = new UsuarioImpl().buscarInformacion(loginDTO);
            if(!loginDTO.getPassword().equals(respuesta.getPassword())){
                respuesta=null;
            }else{
                ICarrito carritoCompras = new CarritoImpl(new UsuarioImpl().buscarId(loginDTO.getUsuario()));
            }
        }
        return new ResponseEntity<UsuarioDTO>(respuesta,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity crearUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
        new UsuarioImpl().crear(usuarioDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity actualizarUsuario(@RequestBody UsuarioModificarDTO usuarioModificarDTO) throws Exception {
        new UsuarioImpl().actualizar(usuarioModificarDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{usuario}")
    public ResponseEntity eliminarUsuario(@PathVariable("usuario") String usuario) throws Exception {
        new UsuarioImpl().eliminar(usuario);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
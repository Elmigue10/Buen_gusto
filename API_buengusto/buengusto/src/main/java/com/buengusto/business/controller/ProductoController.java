package com.buengusto.business.controller;

import com.buengusto.model.dao.ProductoImpl;
import com.buengusto.model.entity.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/producto")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,
        RequestMethod.PUT, RequestMethod.DELETE})
public class ProductoController {

    @GetMapping
    public ResponseEntity<List<Producto>> listarProducto() throws Exception {
        List<Producto> productos = new ProductoImpl().listar();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("buscar/id/{id}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable("id") int id  ) throws Exception {
        Producto producto = new ProductoImpl().buscar(id);
        return new ResponseEntity<>(producto,HttpStatus.OK);
    }

    @GetMapping("buscar/coincidencia/{palabra}")
    public ResponseEntity<List<Producto>> listarProductoConcidencia(@PathVariable("palabra") String palabra) throws Exception {
        List<Producto> productos = new ProductoImpl().listar(palabra);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity agregarProducto(@RequestBody Producto producto) throws Exception {
        new ProductoImpl().crear(producto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity actualizarProducto(@RequestBody Producto producto) throws Exception {
        new ProductoImpl().actualizar(producto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarProducto(@PathVariable("id")int id) throws Exception {
        new ProductoImpl().eliminar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

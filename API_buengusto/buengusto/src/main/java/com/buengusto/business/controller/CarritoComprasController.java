package com.buengusto.business.controller;

import com.buengusto.model.dao.CarritoImpl;
import com.buengusto.model.dao.ICarrito;
import com.buengusto.model.dto.ProductoCantidadDTO;
import com.buengusto.model.entity.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/carritoCompras")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,
        RequestMethod.PUT, RequestMethod.DELETE})
public class CarritoComprasController {

    @GetMapping
    public ResponseEntity<Map<Integer,ProductoCarrito>> listarProductos() throws Exception {
        ICarrito carritoCompras = new CarritoImpl();
        Map<Integer,ProductoCarrito> productos = carritoCompras.listar();
        return new ResponseEntity<>(productos,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity agregarProducto(@RequestBody ProductoCarrito productoCarrito) throws Exception {
        //CarritoCompras.getCarritoCompras().agregarProductoCarritoCompras(productoCarrito);
        ICarrito carritoCompras = new CarritoImpl();
        carritoCompras.agregar(productoCarrito);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity actualizarProducto(@RequestBody ProductoCantidadDTO producto) throws Exception {
        ICarrito carritoCompras = new CarritoImpl();
        carritoCompras.actualizar(producto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarProducto(@PathVariable int id) throws Exception {
        //CarritoCompras.getCarritoCompras().removerProductoCarritoCompras((id));
        ICarrito carritoCompras = new CarritoImpl();
        carritoCompras.eliminar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}

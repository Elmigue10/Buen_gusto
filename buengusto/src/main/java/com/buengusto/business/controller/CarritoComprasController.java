package com.buengusto.business.controller;

import com.buengusto.model.entity.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carritoCompras")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,
    RequestMethod.PUT, RequestMethod.DELETE})
public class CarritoComprasController {

    @GetMapping
    public ResponseEntity<List<ProductoCarrito>> listarProductos(){
        CarritoCompras carritoCompras = CarritoCompras.getCarritoCompras();
        List<ProductoCarrito> productos = carritoCompras.listarProductoCarritoCompras();
        return new ResponseEntity<>(productos,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity agregarProducto(@RequestBody ProductoCarrito productoCarrito) throws Exception {
        CarritoCompras.getCarritoCompras().agregarProductoCarritoCompras(productoCarrito);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}/{cantidad}")
    public ResponseEntity actualizarProducto(@PathVariable("id") int id,@PathVariable("cantidad") int cantidad){
        CarritoCompras.getCarritoCompras().actualizarProductoCarritoCompras(id,cantidad);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity eliminarProducto(@RequestBody ProductoCarrito productoCarrito){
        CarritoCompras.getCarritoCompras().removerProductoCarritoCompras(productoCarrito);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

package com.buengusto;

import com.buengusto.model.dao.IProducto;
import com.buengusto.model.dao.ProductoImpl;
import com.buengusto.model.dto.ProductoCantidadDTO;
import com.buengusto.model.entity.*;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class BuengustoApplicationTests {

    @Test
    void contextLoads() throws Exception {
        CarritoCompras cp = CarritoCompras.getCarritoCompras();
        Gson g = new Gson();
        ProductoCarrito pc = new ProductoCarrito(
                new Producto(
                        1,
                        "String nombre",
                        1000,2,
                        "String descripcion","imagen",
                        new Unidad(1, "libra"),
                        new Agrupacion(1,"Frutas")),10);
        //System.out.println(g.toJson(pc));
        //cp.agregarProductoCarritoCompras(pc);
        //System.out.println(g.toJson(cp.listarProductoCarritoCompras()));
        //cp.removerProductoCarritoCompras(pc);
        //System.out.println(g.toJson(cp.listarProductoCarritoCompras()));
        //System.out.println(new SimpleDateFormat("dd/MM/yyyy"));

        Map<Integer,ProductoCarrito> listaProductos= new HashMap<>();
        listaProductos.put(1,pc);
        System.out.println("listaProductos = " + listaProductos);
        listaProductos.get(1).setCantidad(15);
        System.out.println("listaProductos = " + listaProductos);

    }

}

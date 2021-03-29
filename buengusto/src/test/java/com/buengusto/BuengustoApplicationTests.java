package com.buengusto;

import com.buengusto.model.dao.IDatos;
import com.buengusto.model.dao.ProductoImpl;
import com.buengusto.model.entity.*;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

        IDatos datos = new ProductoImpl();
        //datos.buscar(1).toString();

    }

}

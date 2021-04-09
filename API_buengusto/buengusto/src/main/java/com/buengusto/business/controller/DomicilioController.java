package com.buengusto.business.controller;

import com.buengusto.model.dao.DomicilioImpl;
import com.buengusto.model.dao.IDomicilio;
import com.buengusto.model.dto.DetalleDomicilioDTO;
import com.buengusto.model.dto.DomicilioDTO;
import com.buengusto.model.dto.ProductoDomicilioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/domicilio")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,
    RequestMethod.PUT, RequestMethod.DELETE})
public class DomicilioController {

    @PostMapping
    public ResponseEntity crearDomicilio() throws Exception {
        IDomicilio domicilio = new DomicilioImpl();
        domicilio.crear();
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DomicilioDTO>> listarDomicilios() throws  Exception{
        List<DomicilioDTO> domicilios = new DomicilioImpl().listar();
        return new ResponseEntity<>(domicilios,HttpStatus.OK);
    }

    @GetMapping("detalle/{id}")
    public ResponseEntity<DetalleDomicilioDTO> detalleDomicilio(@PathVariable("id") int id) throws Exception{
        DetalleDomicilioDTO detalle = new DomicilioImpl().buscar(id);
        return new ResponseEntity<>(detalle,HttpStatus.OK);
    }


}

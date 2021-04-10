package com.buengusto.business.controller;

import com.buengusto.model.dao.DomicilioImpl;
import com.buengusto.model.dao.IDomicilio;
import com.buengusto.model.dto.DetalleDomicilioDTO;
import com.buengusto.model.dto.DomicilioDTO;
import com.buengusto.model.dto.EstadoDomicilioDTO;
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

    @PutMapping
    public ResponseEntity cambiarEstado(@RequestBody EstadoDomicilioDTO estadoDomicilioDTO) throws Exception{
        IDomicilio domicilio = new DomicilioImpl();
        int estado=0;
        switch (estadoDomicilioDTO.getEstado()){
            case "PENDIENTE":
                estado=1;
                break;
            case "ENVIADO":
                estado=2;
                break;
            default:
                break;
        }

        domicilio.actualizar(estadoDomicilioDTO.getId(),estado+1);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{estado}")
    public ResponseEntity<List<DomicilioDTO>> listarDomicilios(@PathVariable String estado) throws  Exception{
        List<DomicilioDTO> domicilios = new DomicilioImpl().listar(estado);
        return new ResponseEntity<>(domicilios,HttpStatus.OK);
    }

    @GetMapping("detalle/{id}")
    public ResponseEntity<DetalleDomicilioDTO> detalleDomicilio(@PathVariable("id") int id) throws Exception{
        DetalleDomicilioDTO detalle = new DomicilioImpl().buscar(id);
        return new ResponseEntity<>(detalle,HttpStatus.OK);
    }


}

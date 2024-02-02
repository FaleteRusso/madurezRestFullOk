package com.corenetworks.madurezRestFull.controlador;

import com.corenetworks.madurezRestFull.excepciones.ExcepcionNoEncontrado;
import com.corenetworks.madurezRestFull.modelo.ConsultaMedica;
import com.corenetworks.madurezRestFull.servicio.IConsultaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaControlador {
    @Autowired
    private IConsultaServicio servicio;

    @GetMapping
    public ResponseEntity<List<ConsultaMedica>>consultarTodas() {
        return new ResponseEntity<>(servicio.consultaTodos(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConsultaMedica> crear(@RequestBody ConsultaMedica cm) {
        ConsultaMedica cMBBDD = servicio.crear(cm);
        return new ResponseEntity<>(cMBBDD, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaMedica> consultarUno(@PathVariable("id") int id) {
        ConsultaMedica cm = servicio.consultarUno(id);
        if (servicio.consultarUno(id) == null) {
            throw new ExcepcionNoEncontrado("recurso no encontrado" + id);
        }
        return new ResponseEntity<>(cm, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ConsultaMedica> modificar(@RequestBody ConsultaMedica cm) {
        ConsultaMedica cMBBDD = servicio.consultarUno(cm.getIdConsulta());
        if (cMBBDD == null) {
            throw new ExcepcionNoEncontrado("recurso no encontrado" + cm.getIdConsulta());
        }
        return new ResponseEntity<>(servicio.modificar(cm), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        ConsultaMedica cMBBDD = servicio.consultarUno(id);
        if (cMBBDD == null) {
            throw new ExcepcionNoEncontrado("recurso no encontrado" + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}

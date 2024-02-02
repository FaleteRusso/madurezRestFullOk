package com.corenetworks.madurezRestFull.controlador;

import com.corenetworks.madurezRestFull.excepciones.ExcepcionNoEncontrado;
import com.corenetworks.madurezRestFull.modelo.Medico;
import com.corenetworks.madurezRestFull.servicio.IMedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/medicos")
public class MedicoControlador {
        @Autowired
        private IMedicoServicio servicio;

        @GetMapping
        public ResponseEntity<List<Medico>> consultarTodas() {
            return new ResponseEntity<>(servicio.consultaTodos(), HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<Medico> crear(@RequestBody Medico p) {
            Medico pBBDD = servicio.crear(p);
            return new ResponseEntity<>(pBBDD, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Medico> consultarUno(@PathVariable("id") int id) {
            Medico p = servicio.consultarUno(id);
            if (servicio.consultarUno(id) == null) {
                throw new ExcepcionNoEncontrado("recurso no encontrado" + id);
            }
            return new ResponseEntity<>(p, HttpStatus.OK);
        }

        @PutMapping
        public ResponseEntity<Medico> modificar(@RequestBody Medico m) {
            Medico mBBDD = servicio.consultarUno(m.getIdMedico());
            if (mBBDD==null) {
                throw new ExcepcionNoEncontrado("recurso no encontrado" +m.getIdMedico());
            }
            return new ResponseEntity<>(servicio.modificar(m), HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminar(@PathVariable int id) {
            Medico mBBDD = servicio.consultarUno(id);
            if (mBBDD == null) {
                throw new ExcepcionNoEncontrado("recurso no encontrado" + id);
            }
            servicio.eliminar(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }
}

package com.api.rest.lksbaas.controller;

import com.api.rest.lksbaas.model.DatoVivienda;
import com.api.rest.lksbaas.service.DatoViviendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dato-vivienda")
public class DatoViviendaController {

    private final DatoViviendaService datoViviendaService;

    public DatoViviendaController(DatoViviendaService datoViviendaService) {
        this.datoViviendaService = datoViviendaService;
    }

    @GetMapping
    public ResponseEntity<List<DatoVivienda>> getAllDatoViviendas() {
        return new ResponseEntity<>(datoViviendaService.getAllDatoViviendas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatoVivienda> getDatoViviendaById(@PathVariable Integer id) {
        try {
            DatoVivienda datoVivienda = datoViviendaService.getDatoViviendaById(id);
            return new ResponseEntity<>(datoVivienda, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DatoVivienda> saveDatoVivienda(@RequestBody DatoVivienda datoVivienda) {
        try {
            DatoVivienda savedDatoVivienda = datoViviendaService.saveDatoVivienda(datoVivienda);
            return new ResponseEntity<>(savedDatoVivienda, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDatoVivienda(@PathVariable Integer id) {
        try {
            datoViviendaService.deleteDatoVivienda(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

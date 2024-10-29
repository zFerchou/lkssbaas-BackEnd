package com.api.rest.lksbaas.controller;

import com.api.rest.lksbaas.model.InformacionFinanciera;
import com.api.rest.lksbaas.service.InformacionFinancieraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/informacionfinanciera")
public class InformacionFinancieraController {

    private final InformacionFinancieraService informacionFinancieraService;

    public InformacionFinancieraController(InformacionFinancieraService informacionFinancieraService) {
        this.informacionFinancieraService = informacionFinancieraService;
    }

    @GetMapping
    public ResponseEntity<List<InformacionFinanciera>> getAllInformacionFinancieras() {
        try {
            List<InformacionFinanciera> result = informacionFinancieraService.getAllInformacionFinancieras();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformacionFinanciera> getInformacionFinancieraById(@PathVariable Integer id) {
        try {
            InformacionFinanciera result = informacionFinancieraService.getInformacionFinancieraById(id);
            return result != null ? new ResponseEntity<>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<InformacionFinanciera> saveInformacionFinanciera(@RequestBody InformacionFinanciera informacionFinanciera) {
        try {
            InformacionFinanciera result = informacionFinancieraService.saveInformacionFinanciera(informacionFinanciera);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformacionFinanciera> updateStatus(@PathVariable Integer id, @RequestParam boolean activo) {
        try {
            InformacionFinanciera result = informacionFinancieraService.updateStatus(id, activo);
            return result != null ? new ResponseEntity<>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInformacionFinanciera(@PathVariable Integer id) {
        try {
            informacionFinancieraService.deleteInformacionFinanciera(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

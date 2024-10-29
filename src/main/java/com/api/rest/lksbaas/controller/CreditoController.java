package com.api.rest.lksbaas.controller;

import com.api.rest.lksbaas.model.Credito;
import com.api.rest.lksbaas.service.CreditoService;
import com.api.rest.lksbaas.util.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @GetMapping
    public List<Credito> getAllCreditos() {
        return creditoService.getAllCreditos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Credito> getCreditoById(@PathVariable Integer id) {
        return creditoService.getCreditoById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Credito createCredito(@RequestBody Credito credito) {
        return creditoService.saveCredito(credito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Credito> updateCredito(@PathVariable Integer id, @RequestBody Credito credito) {
        return creditoService.getCreditoById(id)
                .map(existingCredito -> {
                    credito.setId(id);
                    return ResponseEntity.ok(creditoService.saveCredito(credito));
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Modificación: Cambiar el estado a inactivo en lugar de eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deactivateCredito(@PathVariable Integer id) {
        return creditoService.getCreditoById(id)
                .map(existingCredito -> {
                    existingCredito.setActivo(false); // Suponiendo que existe un campo 'activo' en la entidad Credito
                    creditoService.saveCredito(existingCredito);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Métodos para la importación y exportación de Excel

    @GetMapping("/export/excel")
    public ResponseEntity<ByteArrayInputStream> exportToExcel() {
        try {
            List<Credito> creditos = creditoService.getAllCreditos();
            ByteArrayInputStream in = ExcelHelper.creditosToExcel(creditos);
            return ResponseEntity.ok().body(in);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/import/excel")
    public ResponseEntity<Void> importFromExcel(@RequestParam("file") MultipartFile file) {
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                creditoService.saveAll(ExcelHelper.excelToCreditos(file.getInputStream()));
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (IOException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

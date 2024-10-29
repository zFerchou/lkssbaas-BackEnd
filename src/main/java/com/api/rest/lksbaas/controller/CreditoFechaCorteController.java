package com.api.rest.lksbaas.controller;

import com.api.rest.lksbaas.model.CreditoFechaCorte;
import com.api.rest.lksbaas.service.CreditoFechaCorteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/credito-fecha-corte")
public class CreditoFechaCorteController {

    @Autowired
    private CreditoFechaCorteService creditoFechaCorteService;

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportCreditoFechaCorteToExcel() {
        ByteArrayInputStream stream = creditoFechaCorteService.exportToExcel();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=credito_fecha_corte.xlsx");
        return ResponseEntity.ok().headers(headers).body(stream.readAllBytes());
    }

    @PostMapping("/import")
    public ResponseEntity<String> importCreditoFechaCorteFromExcel(@RequestParam("file") MultipartFile file) {
        if (!file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("El archivo debe ser un Excel válido.");
        }

        try {
            creditoFechaCorteService.importFromExcel(file);
            return ResponseEntity.ok("Datos importados exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al importar datos.");
        }
    }

    @GetMapping
    public List<CreditoFechaCorte> getAllCreditoFechaCorte() {
        return creditoFechaCorteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditoFechaCorte> getCreditoFechaCorteById(@PathVariable Integer id) {
        Optional<CreditoFechaCorte> creditoFechaCorte = creditoFechaCorteService.findById(id);
        return creditoFechaCorte.map(ResponseEntity::ok)
                                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CreditoFechaCorte> createCreditoFechaCorte(@RequestBody CreditoFechaCorte creditoFechaCorte) {
        CreditoFechaCorte created = creditoFechaCorteService.save(creditoFechaCorte);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreditoFechaCorte> updateCreditoFechaCorte(@PathVariable Integer id, @RequestBody CreditoFechaCorte creditoFechaCorte) {
        Optional<CreditoFechaCorte> existingCreditoFechaCorte = creditoFechaCorteService.findById(id);
        if (existingCreditoFechaCorte.isPresent()) {
            creditoFechaCorte.setId(id);
            CreditoFechaCorte updated = creditoFechaCorteService.save(creditoFechaCorte);
            return ResponseEntity.ok(updated);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/inactivar/{id}")
    public ResponseEntity<Void> deactivateCreditoFechaCorte(@PathVariable Integer id) {
        Optional<CreditoFechaCorte> existingCreditoFechaCorte = creditoFechaCorteService.findById(id);
        if (existingCreditoFechaCorte.isPresent()) {
            CreditoFechaCorte creditoFechaCorte = existingCreditoFechaCorte.get();
            creditoFechaCorte.setActivo(false);
            creditoFechaCorteService.save(creditoFechaCorte);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

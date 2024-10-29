package com.api.rest.lksbaas.controller;

import com.api.rest.lksbaas.model.CondicionFinanciera;
import com.api.rest.lksbaas.service.CondicionFinancieraService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/condiciones-financieras")
public class CondicionFinancieraController {

    private final CondicionFinancieraService condicionFinancieraService;

    public CondicionFinancieraController(CondicionFinancieraService condicionFinancieraService) {
        this.condicionFinancieraService = condicionFinancieraService;
    }

    @GetMapping
    public List<CondicionFinanciera> getAllCondicionesFinancieras() {
        return condicionFinancieraService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CondicionFinanciera> getCondicionFinancieraById(@PathVariable Integer id) {
        Optional<CondicionFinanciera> condicionFinanciera = condicionFinancieraService.findById(id);
        return condicionFinanciera.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CondicionFinanciera> createCondicionFinanciera(@RequestBody CondicionFinanciera condicionFinanciera) {
        try {
           
            if (condicionFinanciera.getFechaDisposicion() == null || condicionFinanciera.getFechaVencimiento() == null ||
                condicionFinanciera.getFormaAdquisicion() == null || condicionFinanciera.getMontoPesos() <= 0 ||
                condicionFinanciera.getMontoMonedaOrigen() <= 0 || condicionFinanciera.getTasaInteres() <= 0 ||
                condicionFinanciera.getDiferenciaTasa() <= 0 || condicionFinanciera.getOperacionTasa() <= 0 ||
                condicionFinanciera.getTipoMoneda() <= 0 || condicionFinanciera.getPeriodoPagosCapital() <= 0 ||
                condicionFinanciera.getPeriodoPagosInteres() <= 0 || condicionFinanciera.getPeriodoFacturacion() <= 0 ||
                condicionFinanciera.getComisionATasa() <= 0 || condicionFinanciera.getComisionAMonto() <= 0 ||
                condicionFinanciera.getComisionDTasa() <= 0 || condicionFinanciera.getComisionDMonto() <= 0) {
                return ResponseEntity.badRequest().body(null);
            }
            CondicionFinanciera savedCondicionFinanciera = condicionFinancieraService.save(condicionFinanciera);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCondicionFinanciera);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<CondicionFinanciera> updateCondicionFinanciera(@PathVariable Integer id, @RequestBody CondicionFinanciera condicionFinanciera) {
        CondicionFinanciera updatedCondicionFinanciera = condicionFinancieraService.update(id, condicionFinanciera);
        if (updatedCondicionFinanciera != null) {
            return ResponseEntity.ok(updatedCondicionFinanciera);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para inactivar en lugar de eliminar
    @PutMapping("/{id}/inactivar")
    public ResponseEntity<CondicionFinanciera> inactivateCondicionFinanciera(@PathVariable Integer id) {
        Optional<CondicionFinanciera> condicionFinanciera = condicionFinancieraService.findById(id);
        if (condicionFinanciera.isPresent()) {
            CondicionFinanciera existingCondicionFinanciera = condicionFinanciera.get();
            existingCondicionFinanciera.setActivo(false);  // Se marca como inactivo
            condicionFinancieraService.save(existingCondicionFinanciera);
            return ResponseEntity.ok(existingCondicionFinanciera);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

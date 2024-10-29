package com.api.rest.lksbaas.controller;

import com.api.rest.lksbaas.model.IdentificadorCredito;
import com.api.rest.lksbaas.repository.IdentificadorCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/identificadorCredito")
public class IdentificadorCreditoController {

    @Autowired
    private IdentificadorCreditoRepository identificadorCreditoRepository;

    // Obtener todos los créditos activos
    @GetMapping("/activos")
    public List<IdentificadorCredito> getAllCreditosActivos() {
        return identificadorCreditoRepository.findByActivo(true);
    }

    // Obtener un crédito por ID
    @GetMapping("/{id}")
    public ResponseEntity<IdentificadorCredito> getCreditoById(@PathVariable Integer id) {
        Optional<IdentificadorCredito> credito = identificadorCreditoRepository.findById(id);
        return credito.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo crédito
    @PostMapping
    public IdentificadorCredito createCredito(@RequestBody IdentificadorCredito identificadorCredito) {
        return identificadorCreditoRepository.save(identificadorCredito);
    }

    // Actualizar un crédito existente
    @PutMapping("/{id}")
    public ResponseEntity<IdentificadorCredito> updateCredito(@PathVariable Integer id, @RequestBody IdentificadorCredito updatedCredito) {
        Optional<IdentificadorCredito> existingCredito = identificadorCreditoRepository.findById(id);
        if (existingCredito.isPresent()) {
            IdentificadorCredito credito = existingCredito.get();
            credito.setIdeCredito(updatedCredito.getIdeCredito());
            credito.setIdeLineaCredito(updatedCredito.getIdeLineaCredito());
            credito.setFechaOtorgamiento(updatedCredito.getFechaOtorgamiento());
            credito.setTipoAlta(updatedCredito.getTipoAlta());
            credito.setTipoCartera(updatedCredito.getTipoCartera());
            credito.setTipoProducto(updatedCredito.getTipoProducto());
            credito.setDestinoCredito(updatedCredito.getDestinoCredito());
            credito.setClaveSucursal(updatedCredito.getClaveSucursal());
            credito.setNoCuenta(updatedCredito.getNoCuenta());
            credito.setNoContrato(updatedCredito.getNoContrato());
            credito.setNombreFactorado(updatedCredito.getNombreFactorado());
            credito.setRfcFactorado(updatedCredito.getRfcFactorado());
            credito.setActivo(updatedCredito.isActivo());
            return ResponseEntity.ok(identificadorCreditoRepository.save(credito));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Cambiar el estado de un crédito a inactivo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivateCredito(@PathVariable Integer id) {
        Optional<IdentificadorCredito> credito = identificadorCreditoRepository.findById(id);
        if (credito.isPresent()) {
            IdentificadorCredito existingCredito = credito.get();
            existingCredito.setActivo(false); // Cambia el estado a inactivo
            identificadorCreditoRepository.save(existingCredito);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

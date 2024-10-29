package com.api.rest.lksbaas.controller;

import com.api.rest.lksbaas.model.IdentificadorAcreditado;
import com.api.rest.lksbaas.service.IdentificadorAcreditadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/identificadores")
public class IdentificadorAcreditadoController {

    private final IdentificadorAcreditadoService identificadorAcreditadoService;

    public IdentificadorAcreditadoController(IdentificadorAcreditadoService identificadorAcreditadoService) {
        this.identificadorAcreditadoService = identificadorAcreditadoService;
    }

    @GetMapping
    public ResponseEntity<List<IdentificadorAcreditado>> getAllIdentificadores() {
        List<IdentificadorAcreditado> identificadores = identificadorAcreditadoService.getAllIdentificadorAcreditados();
        return new ResponseEntity<>(identificadores, HttpStatus.OK);
    }

    @GetMapping("/{noCliente}")
    public ResponseEntity<IdentificadorAcreditado> getIdentificadorByNoCliente(@PathVariable String noCliente) {
        IdentificadorAcreditado identificador = identificadorAcreditadoService.getIdentificadorAcreditadoByNoCliente(noCliente);
        if (identificador != null) {
            return new ResponseEntity<>(identificador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<IdentificadorAcreditado> createIdentificador(@RequestBody IdentificadorAcreditado identificadorAcreditado) {
        if (identificadorAcreditado.getNoCliente() == null || identificadorAcreditado.getNoCliente().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        IdentificadorAcreditado createdIdentificador = identificadorAcreditadoService.saveIdentificadorAcreditado(identificadorAcreditado);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIdentificador);
    }

    @PutMapping("/inactivar/{noCliente}")
    public ResponseEntity<Void> deactivateIdentificador(@PathVariable String noCliente) {
        IdentificadorAcreditado identificador = identificadorAcreditadoService.getIdentificadorAcreditadoByNoCliente(noCliente);
        if (identificador != null) {
            identificadorAcreditadoService.deleteIdentificadorAcreditado(noCliente);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

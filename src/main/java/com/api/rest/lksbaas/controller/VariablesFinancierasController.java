package com.api.rest.lksbaas.controller;

import com.api.rest.lksbaas.model.VariablesFinancieras;
import com.api.rest.lksbaas.service.VariablesFinancierasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/variablesfinancieras")
public class VariablesFinancierasController {

    private final VariablesFinancierasService variablesFinancierasService;

    public VariablesFinancierasController(VariablesFinancierasService variablesFinancierasService) {
        this.variablesFinancierasService = variablesFinancierasService;
    }

    @GetMapping
    public List<VariablesFinancieras> getAllVariablesFinancieras() {
        return variablesFinancierasService.getAllVariablesFinancieras();
    }

    @GetMapping("/{id}")
    public VariablesFinancieras getVariablesFinancierasById(@PathVariable Integer id) {
        return variablesFinancierasService.getVariablesFinancierasById(id);
    }

    @PostMapping
    public VariablesFinancieras saveVariablesFinancieras(@RequestBody VariablesFinancieras variablesFinancieras) {
        return variablesFinancierasService.saveVariablesFinancieras(variablesFinancieras);
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Integer id, @RequestParam boolean activo) {
        variablesFinancierasService.updateStatus(id, activo);
    }

    
}

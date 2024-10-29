package com.api.rest.lksbaas.controller;

import com.api.rest.lksbaas.model.IdentificadorInversiones;
import com.api.rest.lksbaas.service.IdentificadorInversionesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/identificadorinversiones")
public class IdentificadorInversionesController {

    private final IdentificadorInversionesService identificadorInversionesService;

    public IdentificadorInversionesController(IdentificadorInversionesService identificadorInversionesService) {
        this.identificadorInversionesService = identificadorInversionesService;
    }

    @GetMapping
    public List<IdentificadorInversiones> getAllIdentificadorInversiones() {
        return identificadorInversionesService.getAllIdentificadorInversiones();
    }

    @GetMapping("/{id}")
    public IdentificadorInversiones getIdentificadorInversionesById(@PathVariable Integer id) {
        return identificadorInversionesService.getIdentificadorInversionesById(id);
    }

    @PostMapping
    public IdentificadorInversiones saveIdentificadorInversiones(@RequestBody IdentificadorInversiones identificadorInversiones) {
        return identificadorInversionesService.saveIdentificadorInversiones(identificadorInversiones);
    }

    @PatchMapping("/{id}")
    public IdentificadorInversiones updateStatus(@PathVariable Integer id, @RequestParam boolean activo) {
        return identificadorInversionesService.updateStatus(id, activo);
    }
}

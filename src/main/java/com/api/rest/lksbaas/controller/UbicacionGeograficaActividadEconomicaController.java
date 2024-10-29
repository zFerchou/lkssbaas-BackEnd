package com.api.rest.lksbaas.controller;

import com.api.rest.lksbaas.model.UbicacionGeograficaActividadEconomica;
import com.api.rest.lksbaas.service.UbicacionGeograficaActividadEconomicaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ubicacion-geografica-actividad-economica")
public class UbicacionGeograficaActividadEconomicaController {

    private final UbicacionGeograficaActividadEconomicaService service;

    public UbicacionGeograficaActividadEconomicaController(UbicacionGeograficaActividadEconomicaService service) {
        this.service = service;
    }

    @GetMapping
    public List<UbicacionGeograficaActividadEconomica> findAllUbicaciones() {
        return service.getAllUbicacionGeograficaActividadEconomicas();
    }

    @GetMapping("/{id}")
    public UbicacionGeograficaActividadEconomica findById(@PathVariable Integer id) {
        return service.getUbicacionGeograficaActividadEconomicaById(id);
    }

    @PostMapping
    public UbicacionGeograficaActividadEconomica save(@RequestBody UbicacionGeograficaActividadEconomica ubicacion) {
        return service.saveUbicacionGeograficaActividadEconomica(ubicacion);
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Integer id, @RequestParam boolean activo) {
        service.updateStatus(id, activo);
    }

  
}

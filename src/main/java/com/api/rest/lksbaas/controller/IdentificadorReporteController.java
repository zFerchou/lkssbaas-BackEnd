package com.api.rest.lksbaas.controller;

import com.api.rest.lksbaas.model.IdentificadorReporte;
import com.api.rest.lksbaas.model.IdentificadorReporteId;
import com.api.rest.lksbaas.service.IdentificadorReporteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/identificadorreporte")
public class IdentificadorReporteController {

    private final IdentificadorReporteService identificadorReporteService;

    public IdentificadorReporteController(IdentificadorReporteService identificadorReporteService) {
        this.identificadorReporteService = identificadorReporteService;
    }

    @GetMapping
    public List<IdentificadorReporte> getAllIdentificadorReportes() {
        return identificadorReporteService.getAllIdentificadorReportes();
    }

    @GetMapping("/{periodo}/{claveEntidad}/{reporte}")
    public IdentificadorReporte getIdentificadorReporteById(
            @PathVariable String periodo,
            @PathVariable String claveEntidad,
            @PathVariable int reporte) {
        IdentificadorReporteId id = new IdentificadorReporteId(periodo, claveEntidad, reporte);
        return identificadorReporteService.getIdentificadorReporteById(id);
    }

    @PostMapping
    public IdentificadorReporte saveIdentificadorReporte(@RequestBody IdentificadorReporte identificadorReporte) {
        return identificadorReporteService.saveIdentificadorReporte(identificadorReporte);
    }

    @PutMapping("/{periodo}/{claveEntidad}/{reporte}")
    public IdentificadorReporte updateStatus(
            @PathVariable String periodo,
            @PathVariable String claveEntidad,
            @PathVariable int reporte,
            @RequestParam boolean activo) {
        IdentificadorReporteId id = new IdentificadorReporteId(periodo, claveEntidad, reporte);
        return identificadorReporteService.updateStatus(id, activo);
    }

    @DeleteMapping("/{periodo}/{claveEntidad}/{reporte}")
    public void deleteIdentificadorReporte(
            @PathVariable String periodo,
            @PathVariable String claveEntidad,
            @PathVariable int reporte) {
        IdentificadorReporteId id = new IdentificadorReporteId(periodo, claveEntidad, reporte);
        identificadorReporteService.deleteIdentificadorReporte(id);
    }
}

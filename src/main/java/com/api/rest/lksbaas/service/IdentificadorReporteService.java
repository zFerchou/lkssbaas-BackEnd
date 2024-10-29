package com.api.rest.lksbaas.service;

import com.api.rest.lksbaas.model.IdentificadorReporte;
import com.api.rest.lksbaas.model.IdentificadorReporteId;
import com.api.rest.lksbaas.repository.IdentificadorReporteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentificadorReporteService {

    private final IdentificadorReporteRepository identificadorReporteRepository;

    public IdentificadorReporteService(IdentificadorReporteRepository identificadorReporteRepository) {
        this.identificadorReporteRepository = identificadorReporteRepository;
    }

    // Obtiene todos los reportes
    public List<IdentificadorReporte> getAllIdentificadorReportes() {
        return identificadorReporteRepository.findAll();
    }

    // Obtiene un reporte por su ID compuesto
    public IdentificadorReporte getIdentificadorReporteById(IdentificadorReporteId id) {
        return identificadorReporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("IdentificadorReporte no encontrado con id: " + id));
    }

    // Guarda o actualiza un reporte
    public IdentificadorReporte saveIdentificadorReporte(IdentificadorReporte identificadorReporte) {
        return identificadorReporteRepository.save(identificadorReporte);
    }

    // Cambia el estado de un reporte a inactivo
    public void deleteIdentificadorReporte(IdentificadorReporteId id) {
        IdentificadorReporte identificadorReporte = getIdentificadorReporteById(id);
        identificadorReporte.setActivo(false);  // Cambia el estado a inactivo en lugar de eliminar
        identificadorReporteRepository.save(identificadorReporte);
    }

    // Actualiza el estado activo/inactivo de un reporte
    public IdentificadorReporte updateStatus(IdentificadorReporteId id, boolean activo) {
        IdentificadorReporte identificadorReporte = getIdentificadorReporteById(id);
        identificadorReporte.setActivo(activo);
        return identificadorReporteRepository.save(identificadorReporte);
    }

    // Guarda una lista de reportes
    public void saveAll(List<IdentificadorReporte> list) {
        identificadorReporteRepository.saveAll(list);
    }

    // Recupera todos los reportes
    public List<IdentificadorReporte> findAll() {
        return identificadorReporteRepository.findAll();
    }
}

package com.api.rest.lksbaas.service;

import com.api.rest.lksbaas.model.UbicacionGeograficaActividadEconomica;
import com.api.rest.lksbaas.repository.UbicacionGeograficaActividadEconomicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionGeograficaActividadEconomicaService {

    private final UbicacionGeograficaActividadEconomicaRepository ubicacionGeograficaActividadEconomicaRepository;

    public UbicacionGeograficaActividadEconomicaService(UbicacionGeograficaActividadEconomicaRepository ubicacionGeograficaActividadEconomicaRepository) {
        this.ubicacionGeograficaActividadEconomicaRepository = ubicacionGeograficaActividadEconomicaRepository;
    }

    public List<UbicacionGeograficaActividadEconomica> getAllUbicacionGeograficaActividadEconomicas() {
        return ubicacionGeograficaActividadEconomicaRepository.findAll();
    }

    public UbicacionGeograficaActividadEconomica getUbicacionGeograficaActividadEconomicaById(Integer id) {
        return ubicacionGeograficaActividadEconomicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UbicacionGeograficaActividadEconomica no encontrada con id: " + id));
    }

    public UbicacionGeograficaActividadEconomica saveUbicacionGeograficaActividadEconomica(UbicacionGeograficaActividadEconomica ubicacionGeograficaActividadEconomica) {
        return ubicacionGeograficaActividadEconomicaRepository.save(ubicacionGeograficaActividadEconomica);
    }

    public void updateStatus(Integer id, boolean activo) {
        UbicacionGeograficaActividadEconomica ubicacion = getUbicacionGeograficaActividadEconomicaById(id);
        ubicacion.setActivo(activo);
        ubicacionGeograficaActividadEconomicaRepository.save(ubicacion);
    }

    public List<UbicacionGeograficaActividadEconomica> findAll() {
        return ubicacionGeograficaActividadEconomicaRepository.findAll();
    }

    public void saveAll(List<UbicacionGeograficaActividadEconomica> list) {
        ubicacionGeograficaActividadEconomicaRepository.saveAll(list);
    }
}

package com.api.rest.lksbaas.service;

import com.api.rest.lksbaas.model.DatoVivienda;
import com.api.rest.lksbaas.repository.DatoViviendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatoViviendaService {

    private final DatoViviendaRepository datoViviendaRepository;

    public DatoViviendaService(DatoViviendaRepository datoViviendaRepository) {
        this.datoViviendaRepository = datoViviendaRepository;
    }

    public List<DatoVivienda> getAllDatoViviendas() {
        return datoViviendaRepository.findAll();
    }

    public DatoVivienda getDatoViviendaById(Integer id) {
        return datoViviendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DatoVivienda no encontrado con id: " + id));
    }

    public DatoVivienda saveDatoVivienda(DatoVivienda datoVivienda) {
        return datoViviendaRepository.save(datoVivienda);
    }

    public void deleteDatoVivienda(Integer id) {
        datoViviendaRepository.deleteById(id);
    }
}

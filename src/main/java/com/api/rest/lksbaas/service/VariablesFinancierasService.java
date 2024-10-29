package com.api.rest.lksbaas.service;

import com.api.rest.lksbaas.model.VariablesFinancieras;
import com.api.rest.lksbaas.repository.VariablesFinancierasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariablesFinancierasService {

    private final VariablesFinancierasRepository variablesFinancierasRepository;

    public VariablesFinancierasService(VariablesFinancierasRepository variablesFinancierasRepository) {
        this.variablesFinancierasRepository = variablesFinancierasRepository;
    }

    public List<VariablesFinancieras> getAllVariablesFinancieras() {
        return variablesFinancierasRepository.findAll();
    }

    public VariablesFinancieras getVariablesFinancierasById(Integer id) {
        return variablesFinancierasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("VariablesFinancieras no encontrada con id: " + id));
    }

    public VariablesFinancieras saveVariablesFinancieras(VariablesFinancieras variablesFinancieras) {
        return variablesFinancierasRepository.save(variablesFinancieras);
    }

    public void updateStatus(Integer id, boolean activo) {
        VariablesFinancieras variablesFinancieras = getVariablesFinancierasById(id);
        variablesFinancieras.setActivo(activo);
        variablesFinancierasRepository.save(variablesFinancieras);
    }

    // Cambia el método delete a updateStatus
    public void deleteVariablesFinancieras(Integer id) {
        updateStatus(id, false); // Marca como inactivo en lugar de eliminar
    }

    public List<VariablesFinancieras> findAll() {
        
        return null;
    }

    public void saveAll(List<VariablesFinancieras> list) {
      
    }

	public void updateStatus1(Integer id, boolean activo) {
		// TODO Auto-generated method stub
		
	}
}

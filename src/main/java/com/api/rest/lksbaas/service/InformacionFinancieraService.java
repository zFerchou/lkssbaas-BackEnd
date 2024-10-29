package com.api.rest.lksbaas.service;

import com.api.rest.lksbaas.model.InformacionFinanciera;
import com.api.rest.lksbaas.repository.InformacionFinancieraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformacionFinancieraService {

    private final InformacionFinancieraRepository informacionFinancieraRepository;

    public InformacionFinancieraService(InformacionFinancieraRepository informacionFinancieraRepository) {
        this.informacionFinancieraRepository = informacionFinancieraRepository;
    }

    public List<InformacionFinanciera> getAllInformacionFinancieras() {
        return informacionFinancieraRepository.findAll();
    }

    public InformacionFinanciera getInformacionFinancieraById(Integer id) {
        return informacionFinancieraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("InformacionFinanciera no encontrada con id: " + id));
    }

    public InformacionFinanciera saveInformacionFinanciera(InformacionFinanciera informacionFinanciera) {
        return informacionFinancieraRepository.save(informacionFinanciera);
    }

    public void deleteInformacionFinanciera(Integer id) {
        InformacionFinanciera informacionFinanciera = getInformacionFinancieraById(id);
        informacionFinanciera.setActivo(false);  // Marca como inactivo en lugar de eliminar
        informacionFinancieraRepository.save(informacionFinanciera);
    }

    public InformacionFinanciera updateStatus(Integer id, boolean activo) {
        InformacionFinanciera informacionFinanciera = getInformacionFinancieraById(id);
        informacionFinanciera.setActivo(activo);
        return informacionFinancieraRepository.save(informacionFinanciera);
    }

    public void saveAll(List<InformacionFinanciera> list) {
        informacionFinancieraRepository.saveAll(list);
    }

    public List<InformacionFinanciera> findAll() {
        return informacionFinancieraRepository.findAll();
    }

	public InformacionFinanciera updateStatus1(Integer id, boolean activo) {
		// TODO Auto-generated method stub
		return null;
	}
}

package com.api.rest.lksbaas.service;

import com.api.rest.lksbaas.model.IdentificadorCredito;
import com.api.rest.lksbaas.repository.IdentificadorCreditoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentificadorCreditoService {

    private final IdentificadorCreditoRepository identificadorCreditoRepository;

    public IdentificadorCreditoService(IdentificadorCreditoRepository identificadorCreditoRepository) {
        this.identificadorCreditoRepository = identificadorCreditoRepository;
    }

    public List<IdentificadorCredito> getAllIdentificadorCreditos() {
        return identificadorCreditoRepository.findAll();
    }

    public IdentificadorCredito getIdentificadorCreditoById(Integer id) {
        return identificadorCreditoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("IdentificadorCredito no encontrado con id: " + id));
    }

    public IdentificadorCredito saveIdentificadorCredito(IdentificadorCredito identificadorCredito) {
        return identificadorCreditoRepository.save(identificadorCredito);
    }

    public void deactivateIdentificadorCredito(Integer id) {
        IdentificadorCredito identificadorCredito = identificadorCreditoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("IdentificadorCredito no encontrado con id: " + id));
        identificadorCredito.setActivo(false);
        identificadorCreditoRepository.save(identificadorCredito);
    }

    public void activateIdentificadorCredito(Integer id) {
        IdentificadorCredito identificadorCredito = identificadorCreditoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("IdentificadorCredito no encontrado con id: " + id));
        identificadorCredito.setActivo(true);
        identificadorCreditoRepository.save(identificadorCredito);
    }

	public List<IdentificadorCredito> getInactiveIdentificadorCreditos() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IdentificadorCredito> getActiveIdentificadorCreditos() {
		// TODO Auto-generated method stub
		return null;
	}
}

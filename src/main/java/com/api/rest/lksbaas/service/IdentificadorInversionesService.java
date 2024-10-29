package com.api.rest.lksbaas.service;

import com.api.rest.lksbaas.model.IdentificadorInversiones;
import com.api.rest.lksbaas.repository.IdentificadorInversionesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentificadorInversionesService {

    private final IdentificadorInversionesRepository identificadorInversionesRepository;

    public IdentificadorInversionesService(IdentificadorInversionesRepository identificadorInversionesRepository) {
        this.identificadorInversionesRepository = identificadorInversionesRepository;
    }

    public List<IdentificadorInversiones> getAllIdentificadorInversiones() {
        return identificadorInversionesRepository.findAll();
    }

    public IdentificadorInversiones getIdentificadorInversionesById(Integer id) {
        return identificadorInversionesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("IdentificadorInversiones no encontrada con id: " + id));
    }

    public IdentificadorInversiones saveIdentificadorInversiones(IdentificadorInversiones identificadorInversiones) {
        return identificadorInversionesRepository.save(identificadorInversiones);
    }

    public void deleteIdentificadorInversiones(Integer id) {
        IdentificadorInversiones identificador = identificadorInversionesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("IdentificadorInversiones no encontrada con id: " + id));
        identificador.setActivo(false);
        identificadorInversionesRepository.save(identificador);
    }

    public IdentificadorInversiones updateStatus(Integer id, boolean activo) {
        IdentificadorInversiones identificador = getIdentificadorInversionesById(id);
        identificador.setActivo(activo);
        return identificadorInversionesRepository.save(identificador);
    }

    public void saveAll(List<IdentificadorInversiones> list) {
        identificadorInversionesRepository.saveAll(list);
    }

	public List<IdentificadorInversiones> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}

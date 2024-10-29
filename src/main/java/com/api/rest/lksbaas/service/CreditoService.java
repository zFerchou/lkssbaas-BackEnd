package com.api.rest.lksbaas.service;

import com.api.rest.lksbaas.model.Credito;
import com.api.rest.lksbaas.repository.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditoService {

    @Autowired
    private CreditoRepository creditoRepository;

    public List<Credito> getAllCreditos() {
        return creditoRepository.findAll();
    }

    public Optional<Credito> getCreditoById(Integer id) {
        return creditoRepository.findById(id);
    }

    public Credito saveCredito(Credito credito) {
        return creditoRepository.save(credito);
    }

    public void deleteCredito(Integer id) {
        creditoRepository.deleteById(id);
    }

    public void saveAll(List<Credito> creditos) {
        creditoRepository.saveAll(creditos);
    }

	public List<Credito> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveAll1(List<Credito> list) {
		// TODO Auto-generated method stub
		
	}
}

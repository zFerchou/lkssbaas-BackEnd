package com.api.rest.lksbaas.service;

import com.api.rest.lksbaas.model.CreditoFechaCorte;
import com.api.rest.lksbaas.repository.CreditoFechaCorteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

@Service
public class CreditoFechaCorteService {

    private final CreditoFechaCorteRepository creditoFechaCorteRepository;

    public CreditoFechaCorteService(CreditoFechaCorteRepository creditoFechaCorteRepository) {
        this.creditoFechaCorteRepository = creditoFechaCorteRepository;
    }

    public List<CreditoFechaCorte> getAllCreditoFechaCortes() {
        return creditoFechaCorteRepository.findAll();
    }

    public CreditoFechaCorte getCreditoFechaCorteById(Integer id) {
        return creditoFechaCorteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CreditoFechaCorte no encontrado con id: " + id));
    }

    public CreditoFechaCorte saveCreditoFechaCorte(CreditoFechaCorte creditoFechaCorte) {
        return creditoFechaCorteRepository.save(creditoFechaCorte);
    }

    public void deleteCreditoFechaCorte(Integer id) {
        creditoFechaCorteRepository.deleteById(id);
    }

	public List<CreditoFechaCorte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveAll(List<CreditoFechaCorte> list) {
		// TODO Auto-generated method stub
		
	}

	public void importFromExcel(MultipartFile file) {
		// TODO Auto-generated method stub
		
	}

	public Optional<CreditoFechaCorte> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public CreditoFechaCorte saveAll(CreditoFechaCorte creditoFechaCorte) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public ByteArrayInputStream exportToExcel() {
		// TODO Auto-generated method stub
		return null;
	}

	public CreditoFechaCorte save(CreditoFechaCorte creditoFechaCorte) {
		return creditoFechaCorte;
		// TODO Auto-generated method stub
		
	}
}

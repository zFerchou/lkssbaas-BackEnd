package com.api.rest.lksbaas.service;

import com.api.rest.lksbaas.model.IdentificadorAcreditado;
import com.api.rest.lksbaas.repository.IdentificadorAcreditadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentificadorAcreditadoService {

    private final IdentificadorAcreditadoRepository identificadorAcreditadoRepository;

    public IdentificadorAcreditadoService(IdentificadorAcreditadoRepository identificadorAcreditadoRepository) {
        this.identificadorAcreditadoRepository = identificadorAcreditadoRepository;
    }

    public List<IdentificadorAcreditado> getAllIdentificadorAcreditados() {
        return identificadorAcreditadoRepository.findAll();
    }

    public IdentificadorAcreditado getIdentificadorAcreditadoByNoCliente(String noCliente) {
        return identificadorAcreditadoRepository.findById(noCliente)
                .orElseThrow(() -> new RuntimeException("IdentificadorAcreditado no encontrado con noCliente: " + noCliente));
    }

    public IdentificadorAcreditado saveIdentificadorAcreditado(IdentificadorAcreditado identificadorAcreditado) {
        if (identificadorAcreditado.getNoCliente() == null || identificadorAcreditado.getNoCliente().isEmpty()) {
            throw new RuntimeException("El campo noCliente debe ser asignado antes de guardar.");
        }
        return identificadorAcreditadoRepository.save(identificadorAcreditado);
    }

    public void deleteIdentificadorAcreditado(String noCliente) {
        IdentificadorAcreditado identificadorAcreditado = getIdentificadorAcreditadoByNoCliente(noCliente);
        if (identificadorAcreditado != null) {
            identificadorAcreditado.setActivo(false);
            identificadorAcreditadoRepository.save(identificadorAcreditado);
        }
    }

    public IdentificadorAcreditado activarIdentificadorAcreditado(String noCliente) {
        IdentificadorAcreditado identificadorAcreditado = getIdentificadorAcreditadoByNoCliente(noCliente);
        if (identificadorAcreditado != null) {
            identificadorAcreditado.setActivo(true);
            return identificadorAcreditadoRepository.save(identificadorAcreditado);
        }
        throw new RuntimeException("IdentificadorAcreditado no encontrado con noCliente: " + noCliente);
    }

    public IdentificadorAcreditado desactivarIdentificadorAcreditado(String noCliente) {
        IdentificadorAcreditado identificadorAcreditado = getIdentificadorAcreditadoByNoCliente(noCliente);
        if (identificadorAcreditado != null) {
            identificadorAcreditado.setActivo(false);
            return identificadorAcreditadoRepository.save(identificadorAcreditado);
        }
        throw new RuntimeException("IdentificadorAcreditado no encontrado con noCliente: " + noCliente);
    }

    public void saveAll(List<IdentificadorAcreditado> list) {
        
        identificadorAcreditadoRepository.saveAll(list);
    }

    public List<IdentificadorAcreditado> findAll() {
       
        return identificadorAcreditadoRepository.findAll();
    }
}

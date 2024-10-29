package com.api.rest.lksbaas.service;

import com.api.rest.lksbaas.model.CondicionFinanciera;
import com.api.rest.lksbaas.repository.CondicionFinancieraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CondicionFinancieraService {

    @Autowired
    private CondicionFinancieraRepository condicionFinancieraRepository;

    public List<CondicionFinanciera> findAll() {
        return condicionFinancieraRepository.findAll();
    }

    public Optional<CondicionFinanciera> findById(Integer id) {
        return condicionFinancieraRepository.findById(id);
    }

    public CondicionFinanciera save(CondicionFinanciera condicionFinanciera) {
        return condicionFinancieraRepository.save(condicionFinanciera);
    }

    public CondicionFinanciera update(Integer id, CondicionFinanciera condicionFinanciera) {
        if (condicionFinancieraRepository.existsById(id)) {
            condicionFinanciera.setId(id);
            return condicionFinancieraRepository.save(condicionFinanciera);
        } else {
            return null; // o lanza una excepción adecuada
        }
    }

    public void deleteById(Integer id) {
        condicionFinancieraRepository.deleteById(id);
    }

    public void saveAll(List<CondicionFinanciera> list) {
        condicionFinancieraRepository.saveAll(list);
    }
}

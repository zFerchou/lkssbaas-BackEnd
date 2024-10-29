package com.api.rest.lksbaas.repository;

import com.api.rest.lksbaas.model.IdentificadorCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdentificadorCreditoRepository extends JpaRepository<IdentificadorCredito, Integer> {
    List<IdentificadorCredito> findByActivo(boolean activo);
}

package com.api.rest.lksbaas.repository;

import com.api.rest.lksbaas.model.IdentificadorAcreditado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdentificadorAcreditadoRepository extends JpaRepository<IdentificadorAcreditado, String> {
    
    // activos
    List<IdentificadorAcreditado> findByActivoTrue();

    // inactivos
    List<IdentificadorAcreditado> findByActivoFalse();
}

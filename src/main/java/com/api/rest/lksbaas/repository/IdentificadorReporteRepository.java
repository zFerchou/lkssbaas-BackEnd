package com.api.rest.lksbaas.repository;

import com.api.rest.lksbaas.model.IdentificadorReporte;
import com.api.rest.lksbaas.model.IdentificadorReporteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdentificadorReporteRepository extends JpaRepository<IdentificadorReporte, IdentificadorReporteId> {

    Optional<IdentificadorReporte> findById(IdentificadorReporteId id);

    void deleteById(IdentificadorReporteId id);
}

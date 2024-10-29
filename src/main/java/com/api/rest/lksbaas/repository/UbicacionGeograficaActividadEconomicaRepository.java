package com.api.rest.lksbaas.repository;

import com.api.rest.lksbaas.model.UbicacionGeograficaActividadEconomica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionGeograficaActividadEconomicaRepository extends JpaRepository<UbicacionGeograficaActividadEconomica, Integer> {
}
package com.api.rest.lksbaas.repository;

import com.api.rest.lksbaas.model.CreditoFechaCorte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditoFechaCorteRepository extends JpaRepository<CreditoFechaCorte, Integer> {
}
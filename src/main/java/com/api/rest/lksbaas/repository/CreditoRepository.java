package com.api.rest.lksbaas.repository;

import com.api.rest.lksbaas.model.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Integer> {
}

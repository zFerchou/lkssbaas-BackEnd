package com.api.rest.lksbaas.repository;

import com.api.rest.lksbaas.model.VariablesFinancieras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariablesFinancierasRepository extends JpaRepository<VariablesFinancieras, Integer> {
}

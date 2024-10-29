package com.api.rest.lksbaas.repository;

import com.api.rest.lksbaas.model.InformacionFinanciera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacionFinancieraRepository extends JpaRepository<InformacionFinanciera, Integer> {
}
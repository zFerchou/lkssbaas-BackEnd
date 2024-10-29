
package com.api.rest.lksbaas.repository;

import com.api.rest.lksbaas.model.DatoVivienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatoViviendaRepository extends JpaRepository<DatoVivienda, Integer> {
}

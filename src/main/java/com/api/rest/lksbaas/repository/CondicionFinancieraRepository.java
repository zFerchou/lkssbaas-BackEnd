
package com.api.rest.lksbaas.repository;

import com.api.rest.lksbaas.model.CondicionFinanciera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicionFinancieraRepository extends JpaRepository<CondicionFinanciera, Integer> {
}

package com.api.rest.lksbaas.repository;

import com.api.rest.lksbaas.model.IdentificadorInversiones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdentificadorInversionesRepository extends JpaRepository<IdentificadorInversiones, Integer> {
    // Método para obtener solo los registros activos
    List<IdentificadorInversiones> findAllByActivo(boolean activo);
}

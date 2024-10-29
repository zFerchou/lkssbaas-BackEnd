package com.api.rest.lksbaas.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UbicacionGeograficaActividadEconomica")
public class UbicacionGeograficaActividadEconomica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "localidadDestino", nullable = false, length = 255)
    private String localidadDestino;

    @Column(name = "municipioDestino", nullable = false)
    private int municipioDestino;

    @Column(name = "estadoDestino", nullable = false)
    private int estadoDestino;

    @Column(name = "actEconomicaDestino", nullable = false, length = 255)
    private String actEconomicaDestino;

    @Column(name = "activo", nullable = false)
    private boolean activo; // Campo para el estado activo/inactivo

    @ManyToOne(cascade = CascadeType.ALL) // Cascade para guardar la entidad relacionada automáticamente
    @JoinColumns({
        @JoinColumn(name = "ideCredito", referencedColumnName = "ideCredito"),
        @JoinColumn(name = "ideLineaCredito", referencedColumnName = "ideLineaCredito")
    })
    private IdentificadorCredito identificadorCredito;

    // Métodos

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocalidadDestino() {
        return localidadDestino;
    }

    public void setLocalidadDestino(String localidadDestino) {
        this.localidadDestino = localidadDestino;
    }

    public int getMunicipioDestino() {
        return municipioDestino;
    }

    public void setMunicipioDestino(int municipioDestino) {
        this.municipioDestino = municipioDestino;
    }

    public int getEstadoDestino() {
        return estadoDestino;
    }

    public void setEstadoDestino(int estadoDestino) {
        this.estadoDestino = estadoDestino;
    }

    public String getActEconomicaDestino() {
        return actEconomicaDestino;
    }

    public void setActEconomicaDestino(String actEconomicaDestino) {
        this.actEconomicaDestino = actEconomicaDestino;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public IdentificadorCredito getIdentificadorCredito() {
        return identificadorCredito;
    }

    public void setIdentificadorCredito(IdentificadorCredito identificadorCredito) {
        this.identificadorCredito = identificadorCredito;
    }
}

package com.api.rest.lksbaas.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "IdentificadorReporte")
@IdClass(IdentificadorReporteId.class)
public class IdentificadorReporte implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "periodo", nullable = false, length = 20)
    private String periodo;

    @Id
    @Column(name = "claveEntidad", nullable = false, length = 50)
    private String claveEntidad;

    @Id
    @Column(name = "reporte", nullable = false)
    private String reporte;  // Cambiado de int a String

    @Column(name = "claveInstitucion")
    private String claveInstitucion;

    @Column(name = "claveFederacion")
    private Integer claveFederacion;

    @Column(name = "claveNivel")
    private Integer claveNivel;

    @Column(name = "numeroSubsidiarias")
    private Integer numeroSubsidiarias;

    @Column(name = "activo")
    private boolean activo;

    // Métodos getter y setter

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getClaveEntidad() {
        return claveEntidad;
    }

    public void setClaveEntidad(String claveEntidad) {
        this.claveEntidad = claveEntidad;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public String getClaveInstitucion() {
        return claveInstitucion;
    }

    public void setClaveInstitucion(String claveInstitucion) {
        this.claveInstitucion = claveInstitucion;
    }

    public Integer getClaveFederacion() {
        return claveFederacion;
    }

    public void setClaveFederacion(Integer claveFederacion) {
        this.claveFederacion = claveFederacion;
    }

    public Integer getClaveNivel() {
        return claveNivel;
    }

    public void setClaveNivel(Integer claveNivel) {
        this.claveNivel = claveNivel;
    }

    public Integer getNumeroSubsidiarias() {
        return numeroSubsidiarias;
    }

    public void setNumeroSubsidiarias(Integer numeroSubsidiarias) {
        this.numeroSubsidiarias = numeroSubsidiarias;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

	
}

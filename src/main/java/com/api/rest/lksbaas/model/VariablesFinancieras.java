package com.api.rest.lksbaas.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "VariablesFinancieras")
public class VariablesFinancieras implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "noTitulo", nullable = false)
    private int noTitulo;

    @Column(name = "costoAdquisitivo", nullable = false)
    private double costoAdquisitivo;

    @Column(name = "tasaInt", nullable = false)
    private double tasaInt;

    @Column(name = "grupoRiesgo", nullable = false)
    private int grupoRiesgo;

    @Column(name = "valoracionDirecta", nullable = false)
    private double valoracionDirecta;

    @Column(name = "resultadoValuacion", nullable = false)
    private double resultadoValuacion;

    @Column(name = "activo", nullable = false)
    private boolean activo; // Campo para el estado activo/inactivo

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "identificadorReporte_periodo", referencedColumnName = "periodo"),
        @JoinColumn(name = "identificadorReporte_claveEntidad", referencedColumnName = "claveEntidad"),
        @JoinColumn(name = "identificadorReporte_reporte", referencedColumnName = "reporte")
    })
    private IdentificadorReporte identificadorReporte;

    // Métodos getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNoTitulo() {
        return noTitulo;
    }

    public void setNoTitulo(int noTitulo) {
        this.noTitulo = noTitulo;
    }

    public double getCostoAdquisitivo() {
        return costoAdquisitivo;
    }

    public void setCostoAdquisitivo(double costoAdquisitivo) {
        this.costoAdquisitivo = costoAdquisitivo;
    }

    public double getTasaInt() {
        return tasaInt;
    }

    public void setTasaInt(double tasaInt) {
        this.tasaInt = tasaInt;
    }

    public int getGrupoRiesgo() {
        return grupoRiesgo;
    }

    public void setGrupoRiesgo(int grupoRiesgo) {
        this.grupoRiesgo = grupoRiesgo;
    }

    public double getValoracionDirecta() {
        return valoracionDirecta;
    }

    public void setValoracionDirecta(double valoracionDirecta) {
        this.valoracionDirecta = valoracionDirecta;
    }

    public double getResultadoValuacion() {
        return resultadoValuacion;
    }

    public void setResultadoValuacion(double resultadoValuacion) {
        this.resultadoValuacion = resultadoValuacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public IdentificadorReporte getIdentificadorReporte() {
        return identificadorReporte;
    }

    public void setIdentificadorReporte(IdentificadorReporte identificadorReporte) {
        this.identificadorReporte = identificadorReporte;
    }
}

package com.api.rest.lksbaas.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "IdentificadorInversiones")
public class IdentificadorInversiones implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "entidadInversion", nullable = false, length = 255)
    private String entidadInversion;

    @Column(name = "emisora", nullable = false, length = 255)
    private String emisora;

    @Column(name = "serie", length = 255)
    private String serie;

    @Column(name = "tipoValor", length = 255)
    private String tipoValor;

    @Column(name = "formaAdquisicion")
    private int formaAdquisicion;

    @Column(name = "tipoInversion")
    private int tipoInversion;

    @Column(name = "tipoInstrumento")
    private int tipoInstrumento;

    @Column(name = "clasificacionContable", length = 255)
    private String clasificacionContable;

    @Column(name = "fechaContratacion", length = 8)
    private String fechaContratacion;

    @Column(name = "fechaVencimiento", length = 8)
    private String fechaVencimiento;

    @Column(name = "activo", nullable = false)
    private boolean activo;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "identificadorReporte_periodo", referencedColumnName = "periodo"),
        @JoinColumn(name = "identificadorReporte_claveEntidad", referencedColumnName = "claveEntidad"),
        @JoinColumn(name = "identificadorReporte_reporte", referencedColumnName = "reporte")
    })
    private IdentificadorReporte identificadorReporte;

    // Métodos getter y setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEntidadInversion() {
        return entidadInversion;
    }

    public void setEntidadInversion(String entidadInversion) {
        this.entidadInversion = entidadInversion;
    }

    public String getEmisora() {
        return emisora;
    }

    public void setEmisora(String emisora) {
        this.emisora = emisora;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTipoValor() {
        return tipoValor;
    }

    public void setTipoValor(String tipoValor) {
        this.tipoValor = tipoValor;
    }

    public int getFormaAdquisicion() {
        return formaAdquisicion;
    }

    public void setFormaAdquisicion(int formaAdquisicion) {
        this.formaAdquisicion = formaAdquisicion;
    }

    public int getTipoInversion() {
        return tipoInversion;
    }

    public void setTipoInversion(int tipoInversion) {
        this.tipoInversion = tipoInversion;
    }

    public int getTipoInstrumento() {
        return tipoInstrumento;
    }

    public void setTipoInstrumento(int tipoInstrumento) {
        this.tipoInstrumento = tipoInstrumento;
    }

    public String getClasificacionContable() {
        return clasificacionContable;
    }

    public void setClasificacionContable(String clasificacionContable) {
        this.clasificacionContable = clasificacionContable;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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

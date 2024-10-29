package com.api.rest.lksbaas.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "InformacionFinanciera")
public class InformacionFinanciera implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "concepto", nullable = false, length = 255)
    private String concepto;

    @Column(name = "moneda", nullable = false)
    private int moneda;

    @Column(name = "dato", nullable = false)
    private double dato;

    @Column(name = "reporte")
    private Integer reporte;

    @Column(name = "tipoCartera")
    private Integer tipoCartera;

    @Column(name = "tipoSaldo")
    private Integer tipoSaldo;

    @Column(name = "tipoMovimiento")
    private Integer tipoMovimiento;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "identificadorReporte_periodo", referencedColumnName = "periodo"),
        @JoinColumn(name = "identificadorReporte_claveEntidad", referencedColumnName = "claveEntidad"),
        @JoinColumn(name = "identificadorReporte_reporte", referencedColumnName = "reporte")
    })
    private IdentificadorReporte identificadorReporte;

    @Column(name = "activo", nullable = false)
    private boolean activo;

    // Getters y setters...

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getMoneda() {
        return moneda;
    }

    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }

    public double getDato() {
        return dato;
    }

    public void setDato(double dato) {
        this.dato = dato;
    }

    public Integer getReporte() {
        return reporte;
    }

    public void setReporte(Integer reporte) {
        this.reporte = reporte;
    }

    public Integer getTipoCartera() {
        return tipoCartera;
    }

    public void setTipoCartera(Integer tipoCartera) {
        this.tipoCartera = tipoCartera;
    }

    public Integer getTipoSaldo() {
        return tipoSaldo;
    }

    public void setTipoSaldo(Integer tipoSaldo) {
        this.tipoSaldo = tipoSaldo;
    }

    public Integer getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(Integer tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public IdentificadorReporte getIdentificadorReporte() {
        return identificadorReporte;
    }

    public void setIdentificadorReporte(IdentificadorReporte identificadorReporte) {
        this.identificadorReporte = identificadorReporte;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

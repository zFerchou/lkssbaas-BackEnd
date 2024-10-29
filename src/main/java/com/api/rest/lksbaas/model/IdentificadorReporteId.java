package com.api.rest.lksbaas.model;

import java.io.Serializable;
import java.util.Objects;

public class IdentificadorReporteId implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private String periodo;
    private String claveEntidad;
    private int reporte;

    // Default constructor
    public IdentificadorReporteId() {
    }

    // Parameterized constructor
    public IdentificadorReporteId(String periodo, String claveEntidad, int reporte) {
        this.periodo = periodo;
        this.claveEntidad = claveEntidad;
        this.reporte = reporte;
    }

    // Metodos

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

    public int getReporte() {
        return reporte;
    }

    public void setReporte(int reporte) {
        this.reporte = reporte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentificadorReporteId that = (IdentificadorReporteId) o;
        return reporte == that.reporte &&
                Objects.equals(periodo, that.periodo) &&
                Objects.equals(claveEntidad, that.claveEntidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(periodo, claveEntidad, reporte);
    }
}

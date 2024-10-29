package com.api.rest.lksbaas.model;

import java.io.Serializable;
import java.util.Objects;

public class IdentificadorCreditoId implements Serializable {

    private static final long serialVersionUID = 1L;
    private String ideCredito;
    private String ideLineaCredito;

 // Metodos
    
    public String getIdeCredito() {
        return ideCredito;
    }

    public void setIdeCredito(String ideCredito) {
        this.ideCredito = ideCredito;
    }

    public String getIdeLineaCredito() {
        return ideLineaCredito;
    }

    public void setIdeLineaCredito(String ideLineaCredito) {
        this.ideLineaCredito = ideLineaCredito;
    }

   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentificadorCreditoId that = (IdentificadorCreditoId) o;
        return Objects.equals(ideCredito, that.ideCredito) && 
               Objects.equals(ideLineaCredito, that.ideLineaCredito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ideCredito, ideLineaCredito);
    }
}

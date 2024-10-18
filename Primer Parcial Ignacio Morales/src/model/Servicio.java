package model;

import java.time.LocalDate;

public abstract class Servicio {
    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;

    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws Exception {
        if (codServicio.length() != 6) {
            throw new Exception("El código de servicio debe tener 6 caracteres.");
        }
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }

    public abstract double calcularPrecioFinal(LocalDate dia);
    
    public String getCodServicio() {
        return codServicio;
    }
    

    
    public boolean isEnPromocion() {
        return enPromocion;
    }
}


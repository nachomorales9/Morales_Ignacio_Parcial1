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

//La clase abstracta Servicio define un código de servicio, un porcentaje de descuento y un estado de promoción. Tiene un constructor que chequea el código y un método abstracto para calcular precios.

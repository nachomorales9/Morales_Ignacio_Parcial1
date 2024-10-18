package model;

import java.time.LocalDate;

public class Gastronomia extends Servicio {
    private String gastronomia;
    private double precio;
    private int diaSemDesc; // Día de la semana que se aplica el descuento

    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        if (enPromocion && dia.getDayOfWeek().getValue() == diaSemDesc) {
            return precio - (precio * (porcentajeDescuento / 100));
        }
        return precio;
    }

    @Override
    public String toString() {
        return String.format("Gastronomia [codServicio=%s, enPromocion=%s, precio=%.2f, gastronomia=%s]", 
                             codServicio, enPromocion, precio, gastronomia);
    }
}

package model;

import java.time.LocalDate;

public class Hospedaje extends Servicio {
    private String hospedaje;
    private double precioPorNoche;

    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        if (enPromocion) {
            return precioPorNoche - (precioPorNoche * (porcentajeDescuento / 100));
        }
        return precioPorNoche;
    }

    @Override
    public String toString() {
        return String.format("Hospedaje [codServicio=%s, enPromocion=%s, precioPorNoche=%.2f, hospedaje=%s]", 
                             codServicio, enPromocion, precioPorNoche, hospedaje);
    }
}

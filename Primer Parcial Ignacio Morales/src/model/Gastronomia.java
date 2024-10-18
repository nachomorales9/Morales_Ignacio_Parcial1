package model;

import java.time.LocalDate;

public class Gastronomia extends Servicio {
    private String gastronomia;
    private double precio;
    private int diaSemDesc; 

    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }  // crea un nuevo objeto de la clase Gastronomia, 
    //establece algunos valores relacionados con el servicio, y almacena informacion especifica sobre la gastronomia, el precio y el día de la semana en que se aplica un descuento.

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
//Calcula el precio final aplicando un descuento si está en promoción en el día específico y devuelve una descripción del objeto.

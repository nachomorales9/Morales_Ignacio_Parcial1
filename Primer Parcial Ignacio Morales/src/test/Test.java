package test;

import sistema.Sistema;
import model.Gastronomia;
import model.Hospedaje;
import model.Servicio;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        try {
            Sistema sistema = new Sistema();
            
            System.out.println("1-1 Intentar crear Gastronomia");
            try {
                sistema.agregarGastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            System.out.println("1-2 Crear Gastronomia:");
            try {
                sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
                System.out.println("Gastronomia creada correctamente.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("1-3 Intentar crear Hospedaje:");
            try {
                sistema.agregarHospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("1-4 Crear Hospedaje:");
            try {
                sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
                System.out.println("Hospedaje creado correctamente.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // Cálculo de precios finales
            System.out.println("2-1 Calcular precio final de Gastronomia [489235]:");
            Gastronomia gastronomia = (Gastronomia) sistema.traerServicio("489235");
            if (gastronomia != null) {
                double precioFinal = gastronomia.calcularPrecioFinal(LocalDate.of(2020, 10, 28));
                System.out.println("Precio final de la Hamburguesa criolla: " + precioFinal);
            }

            System.out.println("2-2 Calcular precio final de Hospedaje [287282]:");
            Hospedaje hospedaje = (Hospedaje) sistema.traerServicio("287282");
            if (hospedaje != null) {
                double precioFinal = hospedaje.calcularPrecioFinal(LocalDate.of(2020, 10, 27));
                System.out.println("Precio final de la Cabaña 3 personas: " + precioFinal);
            }

            // Agregar y listar servicios
            System.out.println("3) Agregar más servicios e imprimir la lista:");
            sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
            sistema.agregarHospedaje("489259", 10.0, true, "Habitación triple", 2200.0);
            sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            sistema.agregarHospedaje("758972", 15.0, false, "Habitación simple", 1000.0);

            System.out.println("Lista de servicios:");
            for (Servicio s : sistema.traerServicio(true)) {
            }

         
            System.out.println("4-1) Traer todos los servicios en promoción:");
            for (Servicio s : sistema.traerServicio(true)) { 
                System.out.println(s);
            }

            System.out.println("4-2) Traer todos los servicios en promoción para el día 2020-10-28:");
            for (Servicio s : sistema.traerServicio(true, LocalDate.of(2020, 10, 28))) { // Cambiado a Servicio
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

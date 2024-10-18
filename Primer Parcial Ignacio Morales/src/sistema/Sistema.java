package sistema;

import model.Servicio;     
import model.Hospedaje;    
import model.Gastronomia;   
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;        


public class Sistema {
    private List<Servicio> lstServicio;

    public Sistema() {
        this.lstServicio = new ArrayList<>();
    }

    public Servicio traerServicio(String codServicio) {
        for (Servicio s : lstServicio) {
            if (s.getCodServicio().equals(codServicio)) {
                return s;
            }
        }
        return null;
    }

    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> result = new ArrayList<>();
        for (Servicio s : lstServicio) {
            if (s.isEnPromocion() == enPromocion) {
                result.add(s);
            }
        }
        return result;
    }

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> result = new ArrayList<>();
        for (Servicio s : traerServicio(enPromocion)) {
            if (s.calcularPrecioFinal(dia) != 0) {
                result.add(s);
            }
        }
        return result;
    }

    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
        if (traerServicio(codServicio) != null) {
            throw new Exception("El servicio ya existe.");
        }
        lstServicio.add(new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc));
        return true;
    }

    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        if (traerServicio(codServicio) != null) {
            throw new Exception("El servicio ya existe.");
        }
        lstServicio.add(new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche));
        return true;
    }
}

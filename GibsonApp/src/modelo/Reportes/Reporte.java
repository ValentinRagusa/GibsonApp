package modelo.Reportes;

import modelo.Interfaces.GenerableReporte;

import java.util.Date;

public class Reporte implements GenerableReporte {
    private String tipoReporte;
    private Date fechaGeneracion;

    // Constructor
    public Reporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
        this.fechaGeneracion = new Date();
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    // Implementación del método de la interfaz
    @Override
    public void generarReporte() {
        System.out.println("Generando reporte de tipo: " + tipoReporte);
        System.out.println("Fecha de generación: " + fechaGeneracion);
    }

    @Override
    public void generarReporteDeVentas() {
        System.out.println("Este tipo de reporte no está asociado a ventas directamente.");
    }
    

    @Override
    public String toString() {
        return "Reporte [tipoReporte=" + tipoReporte + ", fechaGeneracion=" + fechaGeneracion + "]";
    }
}

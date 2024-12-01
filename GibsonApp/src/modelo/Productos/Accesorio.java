package modelo.Productos;

import modelo.Excepciones.StockInsuficienteException;

public class Accesorio extends Producto {
    private String compatibilidad; // Compatibilidad con tipos de guitarra (e.g., "Eléctrica", "Acústica")

    // Constructor
    public Accesorio(int ID_Accesorio, String nombre, String compatibilidad, int stock) {
        super(ID_Accesorio, nombre, stock);
        this.compatibilidad = compatibilidad;
    }

    // Getter y Setter
    public String getCompatibilidad() {
        return compatibilidad;
    }

    public void setCompatibilidad(String compatibilidad) {
        this.compatibilidad = compatibilidad;
    }

    // Sobrescritura del método registrarVenta desde Producto
    @Override
    public void registrarVenta(int cantidadVendida) throws StockInsuficienteException {
        if (cantidadVendida > 0 && cantidadVendida <= getStock()) {
            setStock(getStock() - cantidadVendida);
            agregarVenta(cantidadVendida); // Actualizar la cantidad vendida
            System.out.println("Se han vendido " + cantidadVendida + " accesorios " + getNombre());
        } else if (cantidadVendida > getStock()) {
            throw new StockInsuficienteException("Stock insuficiente para vender " + cantidadVendida + " unidades.");
        } else {
            throw new IllegalArgumentException("Cantidad de venta inválida.");
        }
    }

    

    // Método toString personalizado
    @Override
    public String toString() {
        return "Accesorio [ID_Accesorio=" + getIDProducto() + ", nombre=" + getNombre() +
               ", compatibilidad=" + compatibilidad + ", stock=" + getStock() + "]";
    }
}

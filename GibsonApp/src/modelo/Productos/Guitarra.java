package modelo.Productos;

import modelo.Excepciones.StockInsuficienteException;

public class Guitarra extends Producto {
    private String tipo;

    // Constructor
    public Guitarra(int ID_Guitarra, String modelo, String tipo, int stock) {
        super(ID_Guitarra, modelo, stock);
        this.tipo = tipo;
    }

    // Getter y Setter
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Redefinir el método registrarVenta desde Producto
    @Override
    public void registrarVenta(int cantidadVendida) throws StockInsuficienteException {
        if (cantidadVendida > 0 && cantidadVendida <= getStock()) {
            setStock(getStock() - cantidadVendida);
            agregarVenta(cantidadVendida); // Actualizar la cantidad vendida
            System.out.println("Se han vendido " + cantidadVendida + " guitarras del modelo " + getNombre());
        } else if (cantidadVendida > getStock()) {
            throw new StockInsuficienteException("Stock insuficiente para vender " + cantidadVendida + " unidades.");
        } else {
            throw new IllegalArgumentException("Cantidad de venta inválida.");
        }
    }
    
    
    

    // Método toString personalizado
    @Override
    public String toString() {
        return "Guitarra [ID_Guitarra=" + getIDProducto() + ", modelo=" + getNombre() + ", tipo=" + tipo + ", stock=" + getStock() + "]";
    }
}


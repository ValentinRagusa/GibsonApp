package modelo.Productos;
import modelo.Excepciones.StockInsuficienteException;

public abstract class Producto {
    private int ID_Producto;
    private String nombre;
    private int stock;
    private int cantidadVendida = 0;

    // Constructor
    public Producto(int ID_Producto, String nombre, int stock) {
        this.ID_Producto = ID_Producto;
        this.nombre = nombre;
        this.stock = stock;
    }

    // Getters y Setters
    public int getIDProducto() {
        return ID_Producto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    // Método común para actualizar la cantidad vendida
    protected void agregarVenta(int cantidad) {
        this.cantidadVendida += cantidad;
    }

    // Método toString común para todos los productos
    @Override
    public String toString() {
        return "Producto [ID_Producto=" + ID_Producto + ", nombre=" + nombre + ", stock=" + stock + "]";
    }

    // Método abstracto actualizado para lanzar la excepción
    public abstract void registrarVenta(int cantidadVendida) throws StockInsuficienteException;
}


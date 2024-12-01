package modelo.Inventarios;

import modelo.Interfaces.GenerableReporte; // Importamos la interfaz
import modelo.Excepciones.ProductoInvalidoException; // Importamos la excepción personalizada
import modelo.Productos.Producto;

import java.util.ArrayList;

public class Inventario implements GenerableReporte {
    private ArrayList<Producto> listaProductos = new ArrayList<>();
    private int cantidadTotal;

    // Método para agregar productos con manejo de excepciones
    public void agregarProducto(Producto producto) throws ProductoInvalidoException {
        if (producto.getStock() < 0) {
            throw new ProductoInvalidoException("El stock del producto no puede ser negativo.");
        }
        for (Producto p : listaProductos) {
            if (p.getIDProducto() == producto.getIDProducto() || p.getNombre().equalsIgnoreCase(producto.getNombre())) {
                throw new ProductoInvalidoException("El producto ya existe en el inventario.");
            }
        }
        listaProductos.add(producto);
        cantidadTotal++;
        System.out.println("Producto agregado correctamente: " + producto.getNombre());
    }

    // Método para buscar productos por nombre
    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : listaProductos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    // Método para reducir el stock de un producto
    public void reducirStock(Producto producto, int cantidad) {
        if (producto.getStock() >= cantidad) {
            producto.setStock(producto.getStock() - cantidad);
            System.out.println("Stock reducido. Stock actual del producto " + producto.getNombre() + ": " + producto.getStock());
        } else {
            System.out.println("Error: no hay suficiente stock para realizar la venta.");
        }
    }

    // Implementación del método de la interfaz
    @Override
    public void generarReporte() {
        System.out.println("Reporte de Inventario:");
        for (Producto p : listaProductos) {
            System.out.println("Nombre: " + p.getNombre() + ", Stock: " + p.getStock());
        }
    }

    @Override
    public void generarReporteDeVentas() {
        boolean huboVentas = false;
        System.out.println("Generando reporte de ventas desde el Inventario...");
    
        for (Producto producto : listaProductos) {
            int cantidadVendida = producto.getCantidadVendida(); // Método ya implementado en Producto
            if (cantidadVendida > 0) {
                huboVentas = true;
                System.out.println("Producto: " + producto.getNombre() + ", Cantidad Vendida: " + cantidadVendida);
            }
        }
    
        if (!huboVentas) {
            System.out.println("No hubo ventas de ningún producto.");
        }
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }
}

package modelo.Inventarios;
import modelo.Excepciones.PedidoInvalidoException;
import java.util.Date;

public class Pedido {
    private int numPedido;
    private Date fecha;
    private String productosSolicitados;
    private String estado;

    // Constructor
    public Pedido(int numPedido, Date fecha, String productosSolicitados) throws PedidoInvalidoException {
        if (numPedido <= 0) {
            throw new PedidoInvalidoException("El número de pedido debe ser positivo.");
        }
        if (productosSolicitados == null || productosSolicitados.isEmpty()) {
            throw new PedidoInvalidoException("Los productos solicitados no pueden estar vacíos.");
        }
        this.numPedido = numPedido;
        this.fecha = fecha;
        this.productosSolicitados = productosSolicitados;
        this.estado = "Pendiente";
    }

    // Getters y Setters
    public int getNumPedido() {
        return numPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getProductosSolicitados() {
        return productosSolicitados;
    }

    public String getEstado() {
        return estado;
    }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    
    @Override
    public String toString() {
        return "Pedido [numPedido=" + numPedido + ", fecha=" + fecha + ", productosSolicitados=" + productosSolicitados + ", estado=" + estado + "]";
    }
}


import java.util.Scanner;

import modelo.Excepciones.PedidoInvalidoException;
import modelo.Excepciones.ProductoInvalidoException;
import modelo.Excepciones.StockInsuficienteException;
import modelo.Interfaces.GenerableReporte;
import modelo.Inventarios.*;
import modelo.Productos.*;
import modelo.Reportes.*;
import modelo.Usuarios.*;

import java.util.ArrayList;
import java.util.Date;

public class Gibson {
    // Listas para almacenar objetos de cada clase
    private ArrayList<Guitarra> guitarras = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private ArrayList<Reporte> reportes = new ArrayList<>();
    private ArrayList<Empleado> empleados = new ArrayList<>();
    private Inventario inventario = new Inventario();

    // Método para mostrar el menú y manejar la interacción del usuario
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
    
        while (!salir) {
            try {
                System.out.println("Menú:");
                System.out.println("1. Agregar guitarra");
                System.out.println("2. Registrar venta");
                System.out.println("3. Generar reporte de inventario");
                System.out.println("4. Crear pedido");
                System.out.println("5. Generar reporte");
                System.out.println("6. Administrar empleados");
                System.out.println("7. Agregar accesorio");
                System.out.println("8. Salir");
                System.out.print("Seleccione una opción: ");
    
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
    
                switch (opcion) {
                    case 1:
                        agregarGuitarra();
                        break;
                    case 2:
                        registrarVenta();
                        break;
                    case 3:
                        generarReporteInventario();
                        break;
                    case 4:
                        crearPedido();
                        break;
                    case 5:
                        generarReporte();
                        break;
                    case 6:
                        administrarEmpleados();
                        break;
                    case 7:
                        agregarAccesorio();
                        break;
                    case 8:
                        salir = true;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida, intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada inválida. Por favor, intente de nuevo.");
                scanner.nextLine(); // Limpiar buffer en caso de error
            }
        }
        scanner.close();
    }
    
    

    // Método para agregar guitarras al inventario
    public void agregarGuitarra() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Asigne un ID a la guitarra: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        System.out.print("Ingrese el modelo de la guitarra (Les Paul, SG, Explorer, E395): ");
        String modelo = scanner.nextLine();
    
        System.out.print("Ingrese el tipo de la guitarra (Electrica, Acustica): ");
        String tipo = scanner.nextLine();
    
        System.out.print("Ingrese el stock inicial: ");
        int stock = scanner.nextInt();
    
        Guitarra guitarra = new Guitarra(id, modelo, tipo, stock);
    
        try {
            inventario.agregarProducto(guitarra); // Agregar al inventario
            guitarras.add(guitarra); // Agregar a la lista local de guitarras
            System.out.println("Guitarra agregada exitosamente.");
        } catch (ProductoInvalidoException e) {
            System.out.println("Error al agregar la guitarra: " + e.getMessage());
        }
    }
    

    // Método para registrar una venta de guitarras
    public void registrarVenta() {
        if (guitarras.isEmpty()) {
            System.out.println("No hay guitarras disponibles en el inventario para registrar ventas.");
            return;
        }
    
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Modelos disponibles en stock:");
        for (int i = 0; i < guitarras.size(); i++) {
            Guitarra guitarra = guitarras.get(i);
            System.out.println((i + 1) + ". " + guitarra.getNombre() + " - Stock: " + guitarra.getStock());
        }
    
        System.out.print("Seleccione el modelo a vender (número): ");
        int indice = scanner.nextInt() - 1;
    
        if (indice >= 0 && indice < guitarras.size()) {
            Guitarra guitarraSeleccionada = guitarras.get(indice);
    
            System.out.print("Ingrese la cantidad a vender: ");
            int cantidad = scanner.nextInt();
    
            try {
                guitarraSeleccionada.registrarVenta(cantidad);
                System.out.println("Venta registrada exitosamente. Stock restante: " + guitarraSeleccionada.getStock());
            } catch (StockInsuficienteException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Opción inválida.");
        }
    }
    
    


    // Método para generar un reporte de inventario
    public void generarReporteInventario() {
        try {
            // Usamos polimorfismo: `inventario` implementa `GenerableReporte`
            inventario.generarReporte();
        } catch (Exception e) {
            System.out.println("Error al generar el reporte de inventario: " + e.getMessage());
        }
    }
    

    // Método para crear un nuevo pedido
    public void crearPedido() {
    Scanner scanner = new Scanner(System.in);
    try {
        System.out.print("Ingrese el número del pedido: ");
        int numPedido = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingrese los productos solicitados: ");
        String productos = scanner.nextLine();

        Pedido pedido = new Pedido(numPedido, new Date(), productos);
        pedidos.add(pedido);

        System.out.println("Pedido creado exitosamente: " + pedido);
    } catch (PedidoInvalidoException e) {
        System.out.println("Error al crear el pedido: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("Error inesperado: " + e.getMessage());
    }
}


    // Método para generar un reporte (por tipo)
    public void generarReporte() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de reporte:");
        System.out.println("1. Reporte de Inventario");
        System.out.println("2. Reporte de Ventas");
        System.out.print("Opción: ");
    
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
    
        GenerableReporte generableReporte = inventario; // Usamos `inventario` como base para ambos reportes.
    
        switch (opcion) {
            case 1:
                // Generar reporte de inventario
                try {
                    generableReporte.generarReporte();
                } catch (Exception e) {
                    System.out.println("Error al generar el reporte de inventario: " + e.getMessage());
                }
                break;
    
            case 2:
                // Generar reporte de ventas
                try {
                    generableReporte.generarReporteDeVentas();
                } catch (Exception e) {
                    System.out.println("Error al generar el reporte de ventas: " + e.getMessage());
                }
                break;
    
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
    


    // Método para administrar empleados (registrar actividad o asignar tarea)
    public void administrarEmpleados() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Registrar actividad de empleado");
        System.out.println("2. Asignar tarea a empleado");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (opcion == 1) {
            registrarActividadEmpleado();
        } else if (opcion == 2) {
            asignarTareaEmpleado();
        } else {
            System.out.println("Opción no válida.");
        }
    }

    // Método para registrar una actividad de un empleado
    public void registrarActividadEmpleado() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del empleado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el rol del empleado: ");
        String rol = scanner.nextLine();

        Empleado empleado = new Empleado(id, nombre, rol);
        empleados.add(empleado);

        System.out.print("Ingrese la actividad realizada: ");
        String actividad = scanner.nextLine();

        empleado.registrarActividad(actividad);
    }

    // Método para asignar una tarea a un empleado
    public void asignarTareaEmpleado() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del empleado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Empleado empleado = null;
        for (Empleado e : empleados) {
            if (e.getIDEmpleado() == id) {
                empleado = e;
                break;
            }
        }

        if (empleado != null) {
            System.out.print("Ingrese la tarea a asignar: ");
            String tarea = scanner.nextLine();
            empleado.asignarTarea(tarea);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

// Opción en el menú para agregar accesorios
public void agregarAccesorio() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Asigne un ID al accesorio: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // Limpiar buffer

    System.out.print("Ingrese el nombre del accesorio: ");
    String nombre = scanner.nextLine();

    System.out.print("Ingrese la compatibilidad del accesorio (Eléctrica/Acústica): ");
    String compatibilidad = scanner.nextLine();

    System.out.print("Ingrese el stock inicial: ");
    int stock = scanner.nextInt();

    Accesorio accesorio = new Accesorio(id, nombre, compatibilidad, stock);

    try {
        inventario.agregarProducto(accesorio);
        System.out.println("Accesorio agregado exitosamente.");
    } catch (ProductoInvalidoException e) {
        System.out.println("Error al agregar el accesorio: " + e.getMessage());
    }
}


    // Método main para iniciar el programa
    public static void main(String[] args) {
        Gibson gibson = new Gibson();
        gibson.iniciar();
    }
}

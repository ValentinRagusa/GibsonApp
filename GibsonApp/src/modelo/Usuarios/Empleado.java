package modelo.Usuarios;

public class Empleado {
    private static int contadorEmpleados = 0; // Atributo estático
    private int ID_Empleado;
    private String nombre;
    private String rol;

    // Constructor
    public Empleado(int ID_Empleado, String nombre, String rol) {
        this.ID_Empleado = ID_Empleado;
        this.nombre = nombre;
        this.rol = rol;
        contadorEmpleados++;
    }

    // Getters
    public int getIDEmpleado() {
        return ID_Empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    // Método estático para obtener el número total de empleados
    public static int getContadorEmpleados() {
        return contadorEmpleados;
    }

    // Método para registrar una actividad
    public void registrarActividad(String actividad) {
        System.out.println("Actividad registrada para " + nombre + ": " + actividad);
    }

    // Método para asignar una tarea
    public void asignarTarea(String tarea) {
        System.out.println("Tarea asignada a " + nombre + ": " + tarea);
    }

    // Método toString
    @Override
    public String toString() {
        return "Empleado [ID_Empleado=" + ID_Empleado + ", nombre=" + nombre + ", rol=" + rol + "]";
    }
}

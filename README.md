# GibsonApp 🎸

GibsonApp es una aplicación basada en Java que permite gestionar un inventario de productos relacionados con la música, como guitarras y accesorios, así como procesar ventas y generar reportes personalizados. Este proyecto fue desarrollado como parte de un trabajo práctico de Programación Orientada a Objetos, aplicando conceptos avanzados como polimorfismo, manejo de excepciones, interfaces y más.

---

## Funcionalidades principales 🚀

1. **Gestión de inventario**:  
   - Agregar guitarras y accesorios al inventario.  
   - Controlar el stock disponible de cada producto.  

2. **Procesar ventas**:  
   - Registrar ventas de productos del inventario.  
   - Reducir automáticamente el stock del producto vendido.  

3. **Reportes generados dinámicamente**:  
   - Generar reportes de inventario.  
   - Generar reportes de ventas realizadas.  
   - Sistema extensible gracias al uso de interfaces.  

4. **Manejo de errores**:  
   - Excepciones personalizadas para situaciones como stock insuficiente, productos inválidos o pedidos erróneos.  
   - Mejora la experiencia del usuario y asegura la estabilidad de la aplicación.  

---

## Tecnologías utilizadas 🛠️

- **Lenguaje**: Java  
- **Paradigma**: Programación Orientada a Objetos  
- **Características implementadas**:
  - Herencia, polimorfismo y clases abstractas.  
  - Interfaces para estructurar la lógica de generación de reportes.  
  - Manejo de excepciones personalizadas.  
  - Uso de colecciones (`ArrayList`) para gestionar el inventario y los reportes.  

---

## Estructura del proyecto 📂

El proyecto está organizado en los siguientes paquetes:

- **modelo**: Contiene las clases base para los objetos principales de la aplicación.
  - **Inventarios**: Clases relacionadas con la gestión del inventario (`Inventario`, `Pedido`).
  - **Productos**: Clases que representan productos como guitarras y accesorios (`Producto`, `Guitarra`, `Accesorio`).
  - **Reportes**: Clases relacionadas con la generación de reportes (`Reporte`, `GenerableReporte`).
  - **Usuarios**: Gestión de empleados o usuarios del sistema (`Empleado`).

- **excepciones**: Incluye las excepciones personalizadas:
  - `StockInsuficienteException`
  - `ProductoInvalidoException`
  - `PedidoInvalidoException`

---

## Ejecución de la aplicación ▶️

Para ejecutar la aplicación:  

1. Compila el proyecto en tu IDE favorito o desde la terminal usando `javac`.  
2. Corre la clase principal `Gibson.java`, que contiene el menú interactivo para probar todas las funcionalidades.  

El menú permite:  
- Agregar guitarras y accesorios.  
- Registrar ventas de productos.  
- Generar reportes de inventario o ventas realizadas.  

---

## Próximos pasos 🌟

Algunas ideas para expandir el proyecto en el futuro:  
- Incorporar persistencia de datos para guardar el estado del inventario y ventas entre ejecuciones.  
- Crear una interfaz gráfica de usuario (GUI) para hacerlo más intuitivo.  
- Integrar estadísticas avanzadas para analizar las ventas y el rendimiento de los productos.

---

## Contribuciones 🤝

¡Las contribuciones son bienvenidas! Si tienes ideas o mejoras, no dudes en abrir un *pull request* o sugerir cambios.

---

## Licencia 📜

Este proyecto fue creado como un trabajo académico y puede ser utilizado como referencia o base para otros proyectos personales o educativos.  

# GibsonApp 🎸

GibsonApp is a Java-based application designed to manage an inventory of music-related products, such as guitars and accessories, as well as to process sales and generate custom reports. This project was developed as part of an Object-Oriented Programming practical assignment, implementing advanced concepts such as polymorphism, exception handling, interfaces, and more.

---

## Main Features 🚀

1. **Inventory Management**:  
   - Add guitars and accessories to the inventory.  
   - Track available stock for each product.  

2. **Sales Processing**:  
   - Record sales of inventory products.  
   - Automatically update the stock of sold items.  

3. **Dynamic Report Generation**:  
   - Generate inventory reports.  
   - Generate reports on completed sales.  
   - Easily extendable system thanks to the use of interfaces.  

4. **Error Handling**:  
   - Custom exceptions for scenarios such as insufficient stock, invalid products, or incorrect orders.  
   - Enhances user experience and ensures application stability.  

---

## Technologies Used 💻
- **Java**: Object-oriented programming concepts such as inheritance, interfaces, and polymorphism.  
- **Exception Handling**: Custom exceptions to manage application-specific errors effectively.  
- **Data Structures**: Utilized `ArrayList` for dynamic management of products and sales data.  

---

## How to Use 📖

1. Clone this repository:
   ```bash
   git clone https://github.com/ValentinRagusa/GibsonApp.git

import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {

        // Menú interactivo
        Scanner sc = new Scanner(System.in);

        // Instancia base inicial según el constructor de tu UML
        Supermercado supermercado = new Supermercado("Marketplus", "Calle 15 #12-34", 310123456);

        int opcion;
        do {
            System.out.println("\n====== Menú Marketplus =======");

            System.out.println("-----------Clientes-----------");
            System.out.println("1. Registrar cliente.");
            System.out.println("2. Mostrar compras de un cliente.");

            System.out.println("-----------Productos-----------");
            System.out.println("3. Registrar producto.");

            System.out.println("------------Compras-----------");
            System.out.println("4. Registrar compra.");
            System.out.println("5. Generar reporte de ventas por fecha.");

            System.out.println("0. Salir.");

            System.out.print("Seleccione la opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {

                //=============Cliente============
                case 1:
                    System.out.println("------Registrar cliente----");

                    System.out.print("Nombre: ");
                    String nombreCliente = sc.nextLine();

                    System.out.print("Documento: ");
                    int documentoCliente = sc.nextInt();

                    System.out.print("Teléfono: ");
                    int telefonoCliente = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Correo: ");
                    String correoCliente = sc.nextLine();

                    Cliente nuevoCliente = new Cliente(nombreCliente, documentoCliente, telefonoCliente, correoCliente);

                    // TODO: Llamar al método del supermercado cuando lo implementes
                    // supermercado.registrarCliente(nuevoCliente);
                    System.out.println("Cliente creado localmente.");
                    break;

                case 2:
                    System.out.println("-------Mostrar compras de un cliente------");

                    System.out.print("Documento del cliente: ");
                    int documentoBusqueda = sc.nextInt();
                    sc.nextLine();

                    // TODO: Llamar a supermercado.consultarComprasCliente(docBusqueda);
                    System.out.println("Opción en construcción (método pendiente)...");
                    break;

                //=============Producto============
                case 3:
                    System.out.println("------Registrar producto----");

                    System.out.print("Nombre: ");
                    String nombreProd = sc.nextLine();

                    System.out.print("Código: ");
                    String codigoProd = sc.nextLine();

                    System.out.print("Precio Unitario: ");
                    double precioProd = sc.nextDouble();

                    System.out.print("Cantidad Disponible: ");
                    int cantidadProd = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Categorías disponibles:");
                    System.out.println("1. ALIMENTOS | 2. BEBIDAS | 3. PRODUCTOS DE ASEO | 4. CUIDADO PERSONAL");
                    System.out.print("Seleccione la categoría (1-4): ");
                    int opcionCat = sc.nextInt();
                    sc.nextLine();

                    Categoria categoriaSeleccionada = Categoria.ALIMENTOS;
                    if (opcionCat == 2) categoriaSeleccionada = Categoria.BEBIDAS;
                    else if (opcionCat == 3) categoriaSeleccionada = Categoria.PRODUCTOS_ASEO;
                    else if (opcionCat == 4) categoriaSeleccionada = Categoria.CUIDADO_PERSONAL;

                    Producto nuevoProducto = new Producto(nombreProd, codigoProd, precioProd , cantidadProd , categoriaSeleccionada);

                    // TODO: Llamar a supermercado.registrarProducto(nuevoProducto);
                    System.out.println("Producto creado localmente.");
                    break;

                //=============Compra============
                case 4:
                    System.out.println("-------Registrar compra------");

                    System.out.print("Código de la compra: ");
                    String codigoCompra = sc.nextLine();

                    // TODO: Aquí pedirás los datos para armar la compra y llamar a supermercado.registrarCompra(compra);
                    System.out.println("Opción en construcción (método pendiente)...");
                    break;

                case 5:
                    System.out.println("-------Generar reporte de ventas por fecha------");

                    // TODO: Pedir fecha y llamar a supermercado.generarReporteVentasPorFecha(fecha);
                    System.out.println("Opción en construcción (método pendiente)...");
                    break;

                case 0:
                    System.out.println("Programa finalizado.....");
                    break;

                default:
                    System.out.println("Opción no válida....");
            }

        } while (opcion != 0);

        sc.close();
    }
}
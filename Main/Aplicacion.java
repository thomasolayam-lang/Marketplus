import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {

        // Menú interactivo
        Scanner sc = new Scanner(System.in);
// Instancia base inicial
        Supermercado supermercado = new Supermercado("Marketplus", "Calle 15 #12-34", 310123456);
        // ============================================================
// DATOS PRECARGADOS (CORREGIDOS)
// ============================================================

// 1. Clientes precargados (Si el documento en tu clase Cliente es String, usa comillas "")
        Cliente c1 = new Cliente("Carlos Pérez", 1010, "3001234", "carlos@mail.com");
        Cliente c2 = new Cliente("Ana Gómez", 2020, "3115678", "ana@mail.com");

        supermercado.registrarCliente(c1);
        supermercado.registrarCliente(c2);

// 2. Productos precargados (6 parámetros: nombre, codigo, precio, cantidadDisponible, cantidadComprada, categoria)
        Producto p1 = new Producto("Arroz 1kg", "P01", 4500.0, 20, 0, Categoria.ALIMENTOS);
        Producto p2 = new Producto("Leche 1L", "P02", 3800.0, 15, 0, Categoria.BEBIDAS);
        Producto p3 = new Producto("Jabón Líquido", "P03", 8500.0, 10, 0, Categoria.PRODUCTOS_ASEO);
        Producto p4 = new Producto("Shampoo", "P04", 12000.0, 8, 0, Categoria.CUIDADO_PERSONAL);

        supermercado.registrarProducto(p1);
        supermercado.registrarProducto(p2);
        supermercado.registrarProducto(p3);
        supermercado.registrarProducto(p4);

// ============================================================



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
                    String telefonoCliente = sc.nextLine();
                    sc.nextLine();

                    System.out.print("Correo: ");
                    String correoCliente = sc.nextLine();

                    Cliente nuevoCliente = new Cliente(nombreCliente, documentoCliente, telefonoCliente, correoCliente);

                    // Llamado al método del supermercado
                    boolean registrado = supermercado.registrarCliente(nuevoCliente);
                    if (registrado) {
                        System.out.println("Cliente registrado con éxito en el supermercado.");
                    } else {
                        System.out.println("Error: Ya existe un cliente registrado con el documento " + documentoCliente);
                    }
                    break;

                case 2:
                    System.out.println("-------Mostrar compras de un cliente------");

                    System.out.print("Documento del cliente: ");
                    int documentoBusqueda = sc.nextInt();
                    sc.nextLine();

                    // Llamado al método para obtener compras del cliente
                    List<Compra> historial = supermercado.consultarComprasCliente(documentoBusqueda);
                    if (historial != null) {
                        if (historial.isEmpty()) {
                            System.out.println("El cliente no ha realizado compras registradas.");
                        } else {
                            System.out.println("Historial de compras del cliente:");
                            for (Compra c : historial) {
                                System.out.println(c);
                            }
                        }
                    }
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

                    Producto nuevoProducto = new Producto(nombreProd, codigoProd, precioProd, cantidadProd,0, categoriaSeleccionada);

                    // Llamado al método para guardar o incrementar stock
                    supermercado.registrarProducto(nuevoProducto);
                    System.out.println("Producto registrado/actualizado con éxito en el inventario.");
                    break;

                //=============Compra============
                case 4:
                    System.out.println("-------Registrar compra------");

                    System.out.print("Documento del cliente que realiza la compra: ");
                    int docClienteCompra = sc.nextInt();
                    sc.nextLine();

                    Cliente clienteCompra = supermercado.buscarCliente(docClienteCompra);
                    if (clienteCompra == null) {
                        System.out.println("Error: El cliente no se encuentra registrado.");
                        break;
                    }

                    System.out.print("Código de la compra: ");
                    String codigoCompra = sc.nextLine();

                    System.out.println("Seleccione el método de pago:");
                    System.out.println("1. TARJETA | 2. TRANSFERENCIA BANCARIA | 3. EFECTIVO");
                    System.out.print("Opción (1-3): ");
                    int opPago = sc.nextInt();
                    sc.nextLine();

                    MetodoPago pago = MetodoPago.EFECTIVO;
                    if (opPago == 1) pago = MetodoPago.TARJETA;
                    else if (opPago == 2) pago = MetodoPago.TRANSFERENCIA_BANCARIA;

                    // Crear la compra asociada al cliente
                    Compra compra = new Compra(codigoCompra, LocalDate.now(), 0.0, pago, clienteCompra);

                    String agregarMas;
                    do {
                        System.out.print("Ingrese el código del producto a comprar: ");
                        String codProdBusqueda = sc.nextLine();

                        Producto prodEncontrado = supermercado.buscarProducto(codProdBusqueda);
                        if (prodEncontrado == null) {
                            System.out.println("El producto con código " + codProdBusqueda + " no existe.");
                        } else {
                            System.out.print("Ingrese la cantidad a comprar (Disponible: " + prodEncontrado.getCantidadDisponible() + "): ");
                            int cantLlevar = sc.nextInt();
                            sc.nextLine();

                            if (cantLlevar <= 0) {
                                System.out.println("La cantidad debe ser mayor a 0.");
                            } else {
                                // Se asigna la cantidadComprada al objeto de la compra
                                Producto prodParaCompra = new Producto(
                                        prodEncontrado.getNombre(),
                                        prodEncontrado.getCodigo(),
                                        prodEncontrado.getPrecioUnitario(),
                                        prodEncontrado.getCantidadDisponible(),
                                        prodEncontrado.getCantidadComprada(),
                                        prodEncontrado.getCategoria()
                                );
                                prodParaCompra.setCantidadComprada(cantLlevar);

                                compra.agregarProducto(prodParaCompra);
                                System.out.println("Producto agregado a la compra.");
                            }
                        }

                        System.out.print("¿Desea agregar otro producto a la compra? (s/n): ");
                        agregarMas = sc.nextLine();
                    } while (agregarMas.equalsIgnoreCase("s"));

                    if (compra.getListaProductosC().isEmpty()) {
                        System.out.println("No se registraron productos. Compra cancelada.");
                    } else {
                        boolean procesada = supermercado.registrarCompra(compra);
                        if (procesada) {
                            System.out.println("¡Compra registrada e inventario actualizado exitosamente!");
                            System.out.println("Monto total abonado: $" + compra.getValorTotal());
                        } else {
                            System.out.println("No se pudo procesar la compra por falta de inventario o datos inválidos.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("-------Generar reporte de ventas por fecha------");

                    System.out.print("Ingrese la fecha a consultar (Formato YYYY-MM-DD, presione ENTER para hoy): ");
                    String fechaInput = sc.nextLine();

                    LocalDate fechaConsulta;
                    if (fechaInput.trim().isEmpty()) {
                        fechaConsulta = LocalDate.now();
                    } else {
                        try {
                            fechaConsulta = LocalDate.parse(fechaInput);
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de fecha inválido. Usando la fecha de hoy.");
                            fechaConsulta = LocalDate.now();
                        }
                    }

                    double totalVentas = supermercado.calcularTotalVentasDelDia(fechaConsulta);
                    System.out.println("Total de ventas acumuladas para el día " + fechaConsulta + ": $" + totalVentas);
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
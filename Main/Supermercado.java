import java.util.ArrayList;
import java.util.List;

public class Supermercado {

    private String nombre;
    private String direccion;
    private int telefono;

    //creacion de las listas
    private List<Cliente>listaClientes;
    private List<Producto> listaProductos;
    private List<Compra> listaCompras;

    public Supermercado(String nombre, String direccion, int telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;

        //inicializo las listas
        listaClientes= new ArrayList<>();
        listaProductos= new ArrayList<>();
        listaCompras= new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    @Override
    public String toString() {
        return "Supermercado{" +
                "nombre:'" + nombre + '\'' +
                ", direccion:'" + direccion + '\'' +
                ", telefono:" + telefono +
                ", listaClientes:" + listaClientes +
                ", listaProductos:" + listaProductos +
                ", listaCompras:" + listaCompras +
                '}';
    }
    // Registrar cliente
    public boolean registrarCliente(Cliente cliente) {
        boolean registrado = false;

        // Verificamos si existe con el documento
        boolean existe = verificarCliente(cliente.getDocumento());

        // Si NO existe lo agregamos a la lista
        if (existe == false) {
            listaClientes.add(cliente);
            registrado = true;
        }
        return registrado;
    }

    public boolean verificarCliente(int documento) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getDocumento()==(documento)) {
                return true; // El cliente ya existe en el supermercado
            }
        }
        return false;
    }

    //Registrar Producto

    public boolean registrarProducto(Producto nuevoProducto) {
        // Buscamos si el producto ya está en la lista
        Producto productoExistente = buscarProducto(nuevoProducto.getCodigo());

        //  Si ya existe, incrementamos su cantidad/stock
        if (productoExistente != null) {
            int cantidadActual = productoExistente.getCantidadDisponible();
            int cantidadASumar = nuevoProducto.getCantidadDisponible();

            productoExistente.setCantidadDisponible(cantidadActual + cantidadASumar);
            return true;
        }

        // Si no existe, lo agregamos como nuevo a la lista
        listaProductos.add(nuevoProducto);
        return true;
    }

    public Producto buscarProducto(String codigo) {
        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto; // Devuelve el objeto Producto si coincide el código
            }
        }
        return null; // Si termina el bucle y no lo encuentra, retorna null
    }

    //registrar Compra

    public boolean registrarCompra(Compra compra) {
        // 1. Verificar si el cliente de la compra está registrado en el supermercado
        Cliente cliente = compra.getCliente();
        if (!verificarCliente(cliente.getDocumento())) {
            System.out.println("Error: El cliente no está registrado.");
            return false;
        }

        // 2. Verificar disponibilidad de stock para cada producto de la compra
        for (Producto productoCompra : compra.getListaProductosC()) {
            Producto productoInventario = buscarProducto(productoCompra.getCodigo());

            // Si el producto no existe o no hay suficiente inventario
            if (productoInventario == null || productoInventario.getCantidadDisponible() < productoCompra.getCantidadDisponible()) {
                System.out.println("Error: Stock insuficiente para el producto " + productoCompra.getNombre());
                return false;
            }
        }

        // 3. Descontar la cantidad de stock del inventario general
        for (Producto productoCompra : compra.getListaProductos()) {
            Producto productoInventario = buscarProducto(productoCompra.getCodigo());
            int nuevoStock = productoInventario.getCantidadDisponible() - productoCompra.getCantidadDisponible();
            productoInventario.setCantidadDisponible(nuevoStock);
        }

        // 4. Agregar la compra a la lista personal del cliente y a la lista general del supermercado
        cliente.agregarCompra(compra);
        listaCompras.add(compra);

        return true; // Compra procesada con éxito
    }




    }


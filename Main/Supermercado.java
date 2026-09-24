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
}

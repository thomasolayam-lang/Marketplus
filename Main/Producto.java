
public class Producto {
    //ATRIBUTOS
    private String nombre;
    private String codigo;
    private double precioUnitario;
    private int cantidadDisponible;
    private int cantidadComprada;// para diferenciar del stock y la venta
//Relación de producto con categoría

    private Categoria categoria;


    public Producto(String nombre, String codigo, double precioUnitario, int cantidadDisponible, int cantidadComprada, Categoria categoria) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precioUnitario = precioUnitario;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadComprada = cantidadComprada;
        this.categoria = categoria;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", cantidadDisponible=" + cantidadDisponible +
                ", cantidadComprada=" + cantidadComprada +
                ", categoria=" + categoria +
                '}';
    }
}


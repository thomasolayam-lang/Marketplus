
public class Producto {
    //ATRIBUTOS
    private String nombre;
    private String codigo;
    private double precioUnitario;
    private int cantidadDisponible;

//Relación de producto con categoría

    private Categoria categoria;



    public Producto(int cantidadDisponible, Categoria categoria, String codigo, String nombre, double precioUnitario) {
        this.cantidadDisponible = cantidadDisponible;
        this.categoria = categoria;
        this.codigo = codigo;
        this.nombre = nombre;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    @Override
    public String toString() {
        return "Producto{" +
                "cantidadDisponible=" + cantidadDisponible +
                ", nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", categoria=" + categoria +
                '}';
    }





}


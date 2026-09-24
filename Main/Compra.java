import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {


    private String codigo;
    private LocalDate fechaRealizacion;
    private Double valorTotal;

    //listas
    private List<Producto> listaProductosC;
    //relacion Compra con MetodoPago
    private MetodoPago metodoPago;

    //relacion Compra con Cliente
    private Cliente cliente;

    public Compra(String codigo, LocalDate fechaRealizacion, Double valorTotal, MetodoPago metodoPago, Cliente cliente) {
        this.codigo = codigo;
        this.fechaRealizacion = fechaRealizacion;
        this.valorTotal = valorTotal;
        this.metodoPago = metodoPago;
        this.cliente = cliente;

        listaProductosC= new ArrayList<>();
    }

    public List<Producto> getListaProductosC() {
        return listaProductosC;
    }

    public void setListaProductosC(List<Producto> listaProductosC) {
        this.listaProductosC = listaProductosC;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "codigo='" + codigo + '\'' +
                ", fechaRealizacion=" + fechaRealizacion +
                ", valorTotal=" + valorTotal +
                ", metodoPago=" + metodoPago +
                ", cliente=" + cliente +
                '}';
    }
}

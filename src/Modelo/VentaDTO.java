package Modelo;

public class VentaDTO {
    private String nombreCajero;
    private String producto;
    private int cantidad;
    private double totalCosto;

    public VentaDTO(String nombreCajero, String producto, int cantidad, double totalCosto) {
        this.nombreCajero = nombreCajero;
        this.producto = producto;
        this.cantidad = cantidad;
        this.totalCosto = totalCosto;
    }

    public String getNombreCajero() {
        return nombreCajero;
    }

    public void setNombreCajero(String nombreCajero) {
        this.nombreCajero = nombreCajero;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalCosto() {
        return totalCosto;
    }

    public void setTotalCosto(double totalCosto) {
        this.totalCosto = totalCosto;
    }
}

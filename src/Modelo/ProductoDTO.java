package Modelo;

public class ProductoDTO {
    private String id;
    private String nombreProd;
    private double precio;
    private String descripcion;
    private String rutaImg;
    private int stock;

    public ProductoDTO(String id, String nombreProd, double precio, String descripcion, String rutaImg, int stock) {
        this.id = id;
        this.nombreProd = nombreProd;
        this.precio = precio;
        this.descripcion = descripcion;
        this.rutaImg = rutaImg;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaImg() {
        return rutaImg;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

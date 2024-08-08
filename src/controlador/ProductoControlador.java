package controlador;

import Modelo.ProductoDTO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

public class ProductoControlador {
    private MongoCollection<Document> productoColeccion;

    public ProductoControlador(){
        MongoDatabase database = Conexion.getDatabase();
        productoColeccion = database.getCollection("productos");
    }

    public void insertarProducto(ProductoDTO producto){
        Document doc = new Document("id", producto.getId())
                .append("nombre", producto.getNombreProd())
                .append("precio", producto.getPrecio())
                .append("descripcion", producto.getDescripcion())
                .append("rutaImg", producto.getRutaImg())
                .append("stock",producto.getStock());
        productoColeccion.insertOne(doc);
    }


    public ProductoDTO leerProductoPorId(String id) {
        Document query = new Document("id", id);
        Document productoDoc = productoColeccion.find(query).first();

        if (productoDoc != null) {
            return new ProductoDTO(productoDoc.getString("id"), productoDoc.getString("nombre"),
                    productoDoc.getDouble("precio"), productoDoc.getString("descripcion"),
                    productoDoc.getString("rutaImg"),productoDoc.getInteger("stock"));
        }
        return null;
    }

    public List<ProductoDTO> leerTodosProd() {
        List<ProductoDTO> productos = new ArrayList<>();
        for (Document doc : productoColeccion.find()) {
            productos.add(new ProductoDTO(doc.getString("id"), doc.getString("nombre"),
                    doc.getDouble("precio"), doc.getString("descripcion"),
                    doc.getString("rutaImg"), doc.getInteger("stock")));
        }
        return productos;
    }

    public void actualizarProducto(ProductoDTO producto) {
        Document query = new Document("id", producto.getId());
        Document actualizar = new Document("$set", new Document("nombre", producto.getNombreProd())
                .append("precio", producto.getPrecio())
                .append("descripcion", producto.getDescripcion())
                .append("rutaImg", producto.getRutaImg())
                .append("stock",producto.getStock()));
        productoColeccion.updateOne(query, actualizar);
    }

    public void disminuirStock(String id, int cantidad){
        Document doc = productoColeccion.find(eq("id",id)).first();

        if (doc != null){
            int currentStock = doc.getInteger("stock");
            int newStock = currentStock - cantidad;

            productoColeccion.updateOne(eq("id",id),new Document("$set",new Document("stock",newStock)));


        }
    }
    public void eliminarProd(String id) {
        Document query = new Document("id", id);
        productoColeccion.deleteOne(query);
    }

}

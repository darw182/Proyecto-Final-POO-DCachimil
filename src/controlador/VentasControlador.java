package controlador;

import Modelo.VentaDTO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class VentasControlador {
    private MongoCollection<Document> ventas;

    public VentasControlador(){
        MongoDatabase database = Conexion.getDatabase();
        ventas = database.getCollection("ventas");
    }

    public void addSale(VentaDTO venta) {
        Document doc = new Document("nombreCajero", venta.getNombreCajero())
                .append("producto", venta.getProducto())
                .append("cantidad", venta.getCantidad())
                .append("totalCosto", venta.getTotalCosto())
                ;
        ventas.insertOne(doc);
    }

    public List<VentaDTO> todasLasVentas() {
        List<VentaDTO> sales = new ArrayList<>();
        for (Document doc : ventas.find()) {
            sales.add(new VentaDTO(
                    doc.getString("nombreCajero"),
                    doc.getString("producto"),
                    doc.getInteger("cantidad"),
                    doc.getDouble("totalCosto")

            ));
        }
        return sales;
    }

}

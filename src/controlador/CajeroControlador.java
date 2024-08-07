package controlador;


import Modelo.CajeroDTO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class CajeroControlador {
    private MongoCollection<Document> cajeroColeccion;

    public CajeroControlador(){
        MongoDatabase database = Conexion.getDatabase();
        cajeroColeccion = database.getCollection("cajero");
    }

    public void insertarCajero(CajeroDTO cajero){
        Document doc = new Document("nombre",cajero.getNombre())
                .append("apellido",cajero.getApellido())
                .append("id",cajero.getCajeroId())
                .append("usuario", cajero.getUsuario())
                .append("password",cajero.getPassword());
        cajeroColeccion.insertOne(doc);
    }

    public CajeroDTO leerCajero(String usuario, String pass){
        Document query =  new Document("usuario" ,usuario).append("password",pass);
        Document cajeroDoc = cajeroColeccion.find(query).first();

        if (cajeroDoc != null){
            return new CajeroDTO(cajeroDoc.getString("id"),cajeroDoc.getString("usuario"),cajeroDoc.getString("password"),cajeroDoc.getString("nombre")
            ,cajeroDoc.getString("apellido"));

        }

        return null;
    }

    public CajeroDTO leerCajeroPorId(String id){
        Document query = new Document("id", id);
        Document cajeroDoc = cajeroColeccion.find(query).first();

        if (cajeroDoc != null) {
            return new CajeroDTO(cajeroDoc.getString("id"),cajeroDoc.getString("usuario"),cajeroDoc.getString("password"),cajeroDoc.getString("nombre")
                    ,cajeroDoc.getString("apellido"));
        }
        return null;
    }

    public List<CajeroDTO> leerTodosCajero(){
        List<CajeroDTO> cajeros = new ArrayList<>();
        for (Document doc : cajeroColeccion.find()) {
            cajeros.add(new CajeroDTO(doc.getString("id"), doc.getString("usuario"), doc.getString("password"),doc.getString("nombre"),
                    doc.getString("apellido")));
        }
        return cajeros;
    }

    public void actualizarCajero(CajeroDTO cajero){
        Document query = new Document("id",cajero.getCajeroId());
        Document actualizar = new Document("$set",new Document()
                .append("usuario",cajero.getUsuario())
                .append("password", cajero.getPassword())
                .append("nombre",cajero.getNombre())
                .append("apellido",cajero.getApellido()));
        cajeroColeccion.updateOne(query,actualizar);
    }

    public void eliminarCajero(String id){
        Document query = new Document("id",id);
        cajeroColeccion.deleteOne(query);
    }
}

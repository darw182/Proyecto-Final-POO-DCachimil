package controlador;

import Modelo.AdministradorDTO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class AdminControlador {
    private MongoCollection<Document> adminColeccion;

    public AdminControlador(){
        MongoDatabase database = Conexion.getDatabase();
        adminColeccion = database.getCollection("administrador");
    }

    public void insertarAdmin(AdministradorDTO admin){
        Document doc = new Document("id",admin.getId())
                .append("nombre", admin.getNombre())
                .append("password",admin.getPassword());
        adminColeccion.insertOne(doc);
    }

    public AdministradorDTO leerAdmin(String nombre, String pass){
        Document query =  new Document("nombre" ,nombre).append("password",pass);
        Document adminDoc = adminColeccion.find(query).first();

        if (adminDoc != null){
            return new AdministradorDTO(adminDoc.getString("id"),adminDoc.getString("nombre"),adminDoc.getString("password"));

        }

        return null;
    }

    public AdministradorDTO leerAdminPorId(String id){
        Document query = new Document("id", id);
        Document adminDoc = adminColeccion.find(query).first();

        if (adminDoc != null) {
            return new AdministradorDTO(adminDoc.getString("id"), adminDoc.getString("nombre"), adminDoc.getString("password"));
        }
        return null;
    }

    public List<AdministradorDTO> leerTodosAdmin(){
        List<AdministradorDTO> admins = new ArrayList<>();
        for (Document doc : adminColeccion.find()) {
            admins.add(new AdministradorDTO(doc.getString("id"), doc.getString("nombre"), doc.getString("password")));
        }
        return admins;
    }

    public void actualizarAdmin(AdministradorDTO admin){
        Document query = new Document("id",admin.getId());
        Document actualizar = new Document("$set",new Document("nombre", admin.getNombre()))
                .append("password", admin.getPassword());
        adminColeccion.updateOne(query,actualizar);
    }

    public void eliminarAdmin(String id){
        Document query = new Document("id",id);
        adminColeccion.deleteOne(query);
    }
}

package controlador;

import Modelo.TipoUsuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.print.Doc;

public class LoginControlador {
    private MongoDatabase database;

    public LoginControlador(){
        database =  Conexion.getDatabase();
    }

    public boolean validarUsuario(String usuario , String pass, TipoUsuario tipoUsuario){
        MongoCollection<Document> collection;

        if (tipoUsuario == TipoUsuario.ADMINISTRADOR){
            collection = database.getCollection("administrador");

        }else {
            collection = database.getCollection("cajero");
        }

        Document query = new Document("usuario", usuario).append("password", pass);
        Document user =  collection.find(query).first();

        return user != null;
    }
}

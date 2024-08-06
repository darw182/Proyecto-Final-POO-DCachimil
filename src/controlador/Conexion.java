package controlador;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.connection.ConnectionPoolSettings;

import java.util.concurrent.TimeUnit;

public class Conexion {
    private static final String URL = "mongodb://localhost:27017";
    private static final String BASE_DATOS = "Minimarket";
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    //Estoy creando un pool de conexiones con mongodb para un mejor
    //manejo de las transacciones
    public static void conexion(){
        ConnectionPoolSettings connectionPoolSettings = ConnectionPoolSettings.builder()
                .maxSize(50)
                .minSize(5)
                .maxConnectionIdleTime(60, TimeUnit.SECONDS)
                .build();

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(URL))
                .applyToConnectionPoolSettings(builder -> builder.applySettings(connectionPoolSettings))
                .build();

        mongoClient = MongoClients.create(mongoClientSettings);
        database =  mongoClient.getDatabase(BASE_DATOS);
    }

    public static MongoDatabase getDatabase(){
        return database;
    }

    public static void close(){
        if (mongoClient != null){
            mongoClient.close();
        }
    }

}

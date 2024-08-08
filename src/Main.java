import Vista.login;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import controlador.CajeroControlador;
import controlador.Conexion;
import controlador.ProductoControlador;
import controlador.VentasControlador;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        
        Conexion.conexion();
            JFrame frame = new JFrame("login");
            frame.setContentPane(new login().loginPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);

            Runtime.getRuntime().addShutdownHook(new Thread(() -> Conexion.close()));

    }
}

import Vista.login;
import controlador.Conexion;

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

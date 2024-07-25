package Vista;

import javax.swing.*;
import java.awt.*;

public class login {
    public JPanel loginPanel;
    private JLabel logo;
    private JComboBox roles;
    private JTextField userTxt;
    private JTextField passTxt;
    private JButton sesionBtn;
    private JButton salirButton;

    public login(){
        Image logoImg = new ImageIcon("./src/img/logoMarket.png").getImage();
        ImageIcon logoEscalado = new ImageIcon(logoImg.getScaledInstance(300,150,Image.SCALE_SMOOTH));
        logo.setIcon(logoEscalado);

        roles.addItem("Administrador");
        roles.addItem("Cajero");
    }


}

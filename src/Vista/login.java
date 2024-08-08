package Vista;

import Modelo.TipoUsuario;
import controlador.CajeroControlador;
import controlador.LoginControlador;
import controlador.ProductoControlador;
import controlador.VentasControlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
    public JPanel loginPanel;
    private JLabel logo;
    private JComboBox roles;
    private JTextField userTxt;
    private JTextField passTxt;
    private JButton sesionBtn;
    private JButton salirButton;
    private CajeroControlador cajeroControlador;
    private ProductoControlador productoControlador;
    private VentasControlador ventasControlador;

    public login(){
        this.cajeroControlador = new CajeroControlador();
        this.productoControlador = new ProductoControlador();
        //this.ventasControlador = new VentasControlador();
        Image logoImg = new ImageIcon("./src/img/logoMarket.png").getImage();
        ImageIcon logoEscalado = new ImageIcon(logoImg.getScaledInstance(300,150,Image.SCALE_SMOOTH));
        logo.setIcon(logoEscalado);


       roles.setModel(new DefaultComboBoxModel<>(TipoUsuario.values()));
        LoginControlador loginControlador = new LoginControlador();
        sesionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user =  userTxt.getText();
                String pass =  passTxt.getText();
                TipoUsuario tipoUsuario = (TipoUsuario) roles.getSelectedItem();

                if (loginControlador.validarUsuario(user, pass,tipoUsuario)){
                    JOptionPane.showMessageDialog(null, "Login existoso","Mensaje login",JOptionPane.PLAIN_MESSAGE);

                        if (tipoUsuario == TipoUsuario.ADMINISTRADOR){
                            JFrame frame = new JFrame("PanelControlAdmin");
                            frame.setContentPane(new PanelControlAdmin().PanelControl);
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.setResizable(false);
                            frame.setLocationRelativeTo(null);
                            frame.pack();
                            frame.setVisible(true);
                        }else{


                            JFrame frame = new JFrame("PanelCajero");
                            frame.setContentPane(new VistaCajero(productoControlador, ventasControlador).principalPanel);
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.setResizable(false);
                            frame.setLocationRelativeTo(null);
                            frame.pack();
                            frame.setVisible(true);
                        }



                    JFrame framelogin = (JFrame) SwingUtilities.getWindowAncestor(loginPanel);
                    if (framelogin != null) {
                        framelogin.dispose();
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Credenciales no validas","Mensaje login",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame framelogin = (JFrame) SwingUtilities.getWindowAncestor(loginPanel);
                framelogin.dispose();
            }
        });
    }


}

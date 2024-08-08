package Vista;

import Modelo.CajeroDTO;
import controlador.CajeroControlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminCajeros {
    public JPanel panelAdminCaj;
    private JTextField nombretxt;
    private JTextField apellTxt;
    private JTextField userTxt;
    private JTextField passTxt;
    private JButton añadirButton;
    private JButton eliminarButton;
    private JButton mostrarTodosButton;
    private JButton actualizarButton;
    private JTextArea textArea;
    private JTextField idTxt;
    private JButton panelControlButton;
    //private CajeroControlador cajero;

    public AdminCajeros() {
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombretxt.getText();
                String apell = apellTxt.getText();
                String id =  idTxt.getText();
                String user =  userTxt.getText();
                String pass =  passTxt.getText();

                CajeroDTO cajeroDTO = new CajeroDTO(nombre,apell,id,user,pass);
                CajeroControlador cajero = new CajeroControlador();
                cajero.insertarCajero(cajeroDTO);
                textArea.setText("Cajero añadido con exito!!!");

            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombretxt.getText();
                String apell = apellTxt.getText();
                String id =  idTxt.getText();
                String user =  userTxt.getText();
                String pass =  passTxt.getText();

                CajeroDTO cajeroDTO = new CajeroDTO(nombre,apell,id,user,pass);
                CajeroControlador cajero = new CajeroControlador();
                cajero.actualizarCajero(cajeroDTO);
                textArea.setText("Cajero actualizado con exito!!!");
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String id = idTxt.getText();
               CajeroControlador cajero = new CajeroControlador();
               cajero.eliminarCajero(id);
               textArea.setText("Cajero eliminado con exito!!!");
            }
        });
        mostrarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CajeroControlador cajero = new CajeroControlador();
                List<CajeroDTO> cajeros = cajero.leerTodosCajero();

                StringBuilder sb = new StringBuilder();

                for (CajeroDTO cajeroDTO: cajeros){
                    sb.append(cajeroDTO.getCajeroId()).append(" - ").append(cajeroDTO.getNombre())
                            .append(" - ").append(cajeroDTO.getApellido()).append(" - ")
                            .append(cajeroDTO.getUsuario()).append(" - ").append(cajeroDTO.getPassword())
                            .append("\n");
                }
                textArea.setText(sb.toString());
            }
        });

        panelControlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("PanelControlAdmin");
                frame.setContentPane(new PanelControlAdmin().PanelControl);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);

                JFrame frameAdmin = (JFrame) SwingUtilities.getWindowAncestor(panelAdminCaj);
                if (frameAdmin != null) {
                    frameAdmin.dispose();
                }
            }
        });
    }
}

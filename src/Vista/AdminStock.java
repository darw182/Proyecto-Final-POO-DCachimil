package Vista;

import Modelo.ProductoDTO;
import controlador.ProductoControlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminStock {
    public JPanel panelAdminStock;
    private JTextField idTxt;
    private JTextField nombreTxt;
    private JTextField precioTxt;
    private JTextArea descTxt;
    private JTextField imgTxt;
    private JButton imagenButton;
    private JButton añadirButton;
    private JButton actualizarButton;
    private JButton borrarButton;
    private JButton stockButton;
    private JButton panelDeControlButton;
    private JTextField mensajeTxt;
    private JTextField stockTxt;


    public AdminStock() {
        imagenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String paquete = "/img/";
                String imgNombre = JOptionPane.showInputDialog("Ingrese el nombre de la imagen");

                if (imgNombre != null){
                    String ruta = paquete+imgNombre;
                    if (getClass().getResource(ruta) != null){
                        imgTxt.setText(ruta);
                    }else{
                        JOptionPane.showMessageDialog(null, "Imagen no encontrada");
                    }
                }


                /*

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Img","jpg","jpeg","png","gif"));
                int resultado = fileChooser.showOpenDialog(null);

                if (resultado == JFileChooser.APPROVE_OPTION){
                    imgTxt.setText(fileChooser.getSelectedFile().getAbsolutePath());
                }

*/

            }
        });
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idTxt.getText();
                String nombre = nombreTxt.getText();
                double precio = Double.parseDouble(precioTxt.getText());
                String descripcion = descTxt.getText();
                String ruta = imgTxt.getText();
                int stock = Integer.parseInt(stockTxt.getText());

                ProductoControlador productoControlador = new ProductoControlador();
                productoControlador.insertarProducto(new ProductoDTO(id,nombre,precio,descripcion,ruta,stock));
                mensajeTxt.setText("Producto agregado existosamente!!!");
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idTxt.getText();
                String nombre = nombreTxt.getText();
                double precio = Double.parseDouble(precioTxt.getText());
                String descripcion = descTxt.getText();
                String ruta = imgTxt.getText();
                int stock = Integer.parseInt(stockTxt.getText());


                ProductoControlador productoControlador = new ProductoControlador();
                productoControlador.actualizarProducto(new ProductoDTO(id,nombre,precio,descripcion,ruta,stock));
                mensajeTxt.setText("Producto actualizado existosamente!!!");
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idTxt.getText();
                ProductoControlador productoControlador = new ProductoControlador();
                productoControlador.eliminarProd(id);
                mensajeTxt.setText("Producto eliminado existosamente!!!");
            }
        });
        stockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCardProd panelProductos = new PanelCardProd();
                panelProductos.setVisible(true);
            }
        });
        panelDeControlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("PanelControlAdmin");
                frame.setContentPane(new PanelControlAdmin().PanelControl);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);

                JFrame frameAdminStock = (JFrame) SwingUtilities.getWindowAncestor(panelAdminStock);
                if (frameAdminStock != null) {
                    frameAdminStock.dispose();
                }
            }
        });
    }
}

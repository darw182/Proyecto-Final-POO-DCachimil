package Vista;

import Modelo.ProductoDTO;
import Modelo.VentaDTO;
import controlador.ProductoControlador;
import controlador.VentasControlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaCajero {
    public JPanel principalPanel;
    private JScrollPane scrollPanel;
    private JPanel productoPanel;
    private JComboBox productos;
    private JTextField cantidadTxt;
    private JTextField nombreTxt;
    private JButton venderBtn;
    ProductoControlador productoControlador = new ProductoControlador();
    VentasControlador ventasControlador = new VentasControlador();


    public VistaCajero(ProductoControlador productoControlador, VentasControlador ventasControlador){



        this.productoControlador = productoControlador;
        this.ventasControlador = ventasControlador;

        /*
        setTitle("Cajero");
        setSize(800,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(principalPanel);
*/
        productoPanel.setLayout(new GridLayout(0,3,10,10));

        loadProductData();

        venderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoDTO seleccionarProd = (ProductoDTO) productos.getSelectedItem();

                if (seleccionarProd != null){
                    int cantidad =Integer.parseInt(cantidadTxt.getText());
                    double totalCosto = seleccionarProd.getPrecio() * cantidad;

                    VistaCajero.this.productoControlador.disminuirStock(seleccionarProd.getId(), cantidad);
                    seleccionarProd.setStock(seleccionarProd.getStock() - cantidad);

                    VentaDTO venta = new VentaDTO(nombreTxt.getText(), seleccionarProd.getNombreProd(), cantidad,totalCosto);
                    VistaCajero.this.ventasControlador.addSale(venta);

                    loadProductData();
                }
            }
        });
    }

    private void loadProductData() {
        List<ProductoDTO> products = productoControlador.leerTodosProd();
        productoPanel.removeAll();
        productos.removeAllItems();

        for (ProductoDTO productoDTO: products){
            if (productoDTO.getStock() > 0){
               CardProd productCard = new CardProd(productoDTO);
               productoPanel.add(productCard);
               productos.addItem(productoDTO);
            }
        }

        productoPanel.revalidate();
        productoPanel.repaint();
    }
}

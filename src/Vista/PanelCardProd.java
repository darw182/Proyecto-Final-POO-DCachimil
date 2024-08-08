package Vista;

import Modelo.ProductoDTO;
import controlador.ProductoControlador;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelCardProd extends JFrame{
    private JPanel panelPrincipal;
    private JPanel productosPanel;
    private JScrollPane scrollPanel;

    public PanelCardProd(){

        setTitle("Productos");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panelPrincipal);

        productosPanel.setLayout(new GridLayout(0,3,10,10));
        cargarProductos();
    }

    private void cargarProductos(){

        ProductoControlador productoControlador = new ProductoControlador();
        List<ProductoDTO> productos = productoControlador.leerTodosProd();
        productosPanel.removeAll();

        for (ProductoDTO productoDTO: productos){
            CardProd cardProd = new CardProd(productoDTO);
            productosPanel.add(cardProd);
        }

        productosPanel.revalidate();
        productosPanel.repaint();
    }


}

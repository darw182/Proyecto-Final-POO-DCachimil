package Vista;

import Modelo.ProductoDTO;

import javax.swing.*;
import java.awt.*;

public class CardProd extends JPanel{
    private JPanel cardPanel;
    private JLabel imgLbl;
    private JLabel nomLbl;
    private JLabel precioLbl;
    private JTextArea descTxt;
    private JLabel idLbl;
    private JLabel stock;

    public CardProd(ProductoDTO productoDTO){
        add(cardPanel);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(productoDTO.getRutaImg()));
        Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        imgLbl.setIcon(new ImageIcon(image));

        idLbl.setText(productoDTO.getId());
        nomLbl.setText(productoDTO.getNombreProd());
        stock.setText("Cantidad:"+productoDTO.getStock());
        precioLbl.setText("Precio: $"+productoDTO.getPrecio());
        descTxt.setText(productoDTO.getDescripcion());
    }
}

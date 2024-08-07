package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelControlAdmin {
    private JButton admCajeroBtn;
    private JButton admStockBtn;
    private JButton admVentaBtn;
    public JPanel PanelControl;


    public PanelControlAdmin() {
        admCajeroBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Panel Admin Cajeros");
                frame.setContentPane(new AdminCajeros().panelAdminCaj);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);

                JFrame frameAdmin = (JFrame) SwingUtilities.getWindowAncestor(PanelControl);
                if (frameAdmin != null) {
                    frameAdmin.dispose();
                }
            }
        });
    }
}

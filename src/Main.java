import Vista.login;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
            JFrame frame = new JFrame("login");
            frame.setContentPane(new login().loginPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);

    }
}

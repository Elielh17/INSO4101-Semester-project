import javax.swing.*;

public class BackImage extends JFrame {
    JLabel L1;

    public BackImage() {
        setTitle("Background");
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setContentPane(new JLabel(new ImageIcon("C:\\Users\\eliel\\OneDrive\\Escritorio\\Uni files\\NewLogocut.jpg")));
        L1 = new JLabel();
        add(L1);
        setSize(500,500);

    }

}

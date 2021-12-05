package shooter;

import javax.swing.*;
import java.awt.*;

public class SharpShooter extends JFrame {

    int frameWidth = 720;
    int frameHeight = 750;
    static JLabel statusBar = new JLabel("Press the SPACE bar to start the game");

    public SharpShooter() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(frameWidth, frameHeight);
        setTitle("Sharp shooter");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        setNames();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        add(statusBar, BorderLayout.SOUTH);
        add(new Canvas(), BorderLayout.CENTER);

        setVisible(true);
    }

    private void setNames() {
        statusBar.setName("Statusbar");
    }

    public static void setStatusBar(String message) {
        statusBar.setText(message);
    }
}
import javax.swing.*;

public class Frame extends JFrame {
    public Frame(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }
}

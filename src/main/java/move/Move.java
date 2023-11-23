package move;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public abstract class Move extends JComponent implements Comparable<Move> {
    public JLabel label;

    public int x, y;
    public int velX = 2, velY = 2;

    public Move(String unicode, int x, int y, int velX, int velY) {
        this.x = x;
        this.y = y;
        this.velX = velX;
        this.velY = velY;

        this.label = new JLabel(unicode);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setBounds(x, y, label.getPreferredSize().width, label.getPreferredSize().height);
        add(label);
    }
}

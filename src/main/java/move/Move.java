package move;

import lombok.Getter;

import javax.swing.*;

@Getter
public abstract class Move extends JComponent implements Comparable<Move> {
    private JLabel label;

    private int x, y;
    private int velX = 2, velY = 2;

    public Move(String imagePath, int x, int y) {
        this.x = x;
        this.y = y;

        ImageIcon emojiIcon = new ImageIcon(imagePath);
        this.label = new JLabel(emojiIcon);
        label.setBounds(x, y, emojiIcon.getIconWidth(), emojiIcon.getIconHeight());
        add(label);
    }


}

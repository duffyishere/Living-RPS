package move;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public abstract class Move extends JComponent implements Comparable<Move> {
    public Coordinate coordinate;
    public Coordinate speed;
    public JLabel label;

    public Move(String unicode, Coordinate coordinate, Coordinate speed) {
        this.coordinate = coordinate;
        this.speed = speed;

        this.label = new JLabel(unicode);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setBounds(coordinate.x, coordinate.y, label.getPreferredSize().width, label.getPreferredSize().height);
    }

    public void updatePosition() {
        this.coordinate.x += this.speed.x;
        this.coordinate.y += this.speed.y;
    }

    public void checkBoundary(int width, int height) {
        if (this.coordinate.x + this.label.getWidth() > width) {
            this.speed.x *= -1;
        }
        if (this.coordinate.x < 0) {
            this.speed.x *= -1;
        }
        if (this.coordinate.y + this.label.getWidth() > height) {
            this.speed.y *= -1;
        }
        if (this.coordinate.y < 0) {
            this.speed.y *= -1;
        }
    }
}

package move;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public abstract class Move extends JComponent {
    public Coordinate coordinate;
    public Coordinate speed;
    public JLabel label;

    public abstract String getUnicode();
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

    public boolean isColliding(Move another) {
        Rectangle boundsThis = this.label.getBounds();
        Rectangle boundsAnother = another.label.getBounds();

        return boundsThis.intersects(boundsAnother);
    }

    public Move convertTo(Class<? extends Move> newType) {
        return convert(this, newType);
    }

    private Move convert(Move from, Class<? extends Move> newType) {
        if (newType.equals(Scissor.class)) {
            return new Scissor(from.getCoordinate(), from.getSpeed());
        } else if (newType.equals(Paper.class)) {
            return new Paper(from.getCoordinate(), from.getSpeed());
        } else if (newType.equals(Rock.class)) {
            return new Rock(from.getCoordinate(), from.getSpeed());
        } else {
            return from;  // or throw an exception
        }
    }
}

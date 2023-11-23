import move.Coordinate;
import move.Move;
import move.Paper;
import move.Rock;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Frame extends JFrame {
    public Frame(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        List<Move> emojis = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            Rock rock = new Rock(Coordinate.generateRandomCoordinate(width, height),
                    Coordinate.generateRandomSpeed());
            emojis.add(rock);
            add(rock.label);

            Paper paper = new Paper(Coordinate.generateRandomCoordinate(width, height),
                    Coordinate.generateRandomSpeed());
            emojis.add(paper);
            add(paper.label);
        }

        Timer timer = new Timer(10, e -> {
            for (Move emoji : emojis) {
                emoji.checkBoundary(getWidth(), getHeight());
                emoji.updatePosition();
                emoji.label.setBounds(emoji.coordinate.x, emoji.coordinate.y, emoji.label.getWidth(), emoji.label.getHeight());
            }
        });

        timer.start();

        setVisible(true);
    }
}

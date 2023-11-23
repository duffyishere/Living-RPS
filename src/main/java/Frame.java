import move.*;

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

            Scissor scissor = new Scissor(Coordinate.generateRandomCoordinate(width, height),
                    Coordinate.generateRandomSpeed());
            emojis.add(scissor);
            add(scissor.label);
        }

        Timer timer = new Timer(30, e -> {
            for (int i = 0; i < emojis.size(); ++i) {
                for (int j = i + 1; j < emojis.size(); ++j) {
                    if (emojis.get(i).isColliding(emojis.get(j))) {
                        int compareResult = emojis.get(i).compareTo(emojis.get(j));
                        emojis.get(i).changeEmoji(compareResult, emojis.get(j));
                    }
                }
            }

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

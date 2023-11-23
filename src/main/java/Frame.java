import move.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Frame extends JFrame {
    public Frame(String title, int width, int height, int initialCount) {
        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        List<Move> emojis = new ArrayList<>();

        for (int i = 0; i < initialCount; i++) {
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
                    Move emoji1 = emojis.get(i);
                    Move emoji2 = emojis.get(j);

                    if (emoji1.isColliding(emoji2)) {
                        int compareResult = emoji1.compareTo(emoji2);
                        if (compareResult > 0) { // 이긴 경우
                            remove(emoji2.label);
                            Move newEmoji = emoji2.convertTo(emoji1.getClass());
                            emojis.set(j, newEmoji);
                            add(newEmoji.label);
                        } else if (compareResult < 0) { // 진 경우
                            remove(emoji1.label);
                            Move newEmoji = emoji1.convertTo(emoji2.getClass());
                            emojis.set(i, newEmoji);
                            add(newEmoji.label);
                        }
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

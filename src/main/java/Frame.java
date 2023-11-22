import move.Move;
import move.Rock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Frame extends JFrame {

    public Frame(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        List<Move> emojis = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            Move move = new Rock(random.nextInt(width), random.nextInt(height));
            emojis.add(move);
            add(move.label);
        }

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Move emoji : emojis) {
                    if (emoji.x + emoji.label.getWidth() > getWidth()) {
                        emoji.velX = -2;
                    }
                    else if (emoji.x < 0) {
                        emoji.velX = 2;
                    }
                    if (emoji.y + emoji.label.getHeight() > getHeight()) {
                        emoji.velY = -2;
                    }
                    else if (emoji.y < 0) {
                        emoji.velY = 2;
                    }

                    emoji.x += emoji.velX;
                    emoji.y += emoji.velY;
                    emoji.label.setBounds(emoji.x, emoji.y, emoji.label.getWidth(), emoji.label.getHeight());
                }
            }
        });

        timer.start();

        setVisible(true);
    }
}

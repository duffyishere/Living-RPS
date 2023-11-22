import move.Move;
import move.Rock;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Frame extends JFrame {

    public Frame(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);

        List<Move> emojis = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            emojis.add(new Rock(random.nextInt(width), random.nextInt(height)));
        }
    }
}

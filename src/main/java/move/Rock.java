package move;

import lombok.Getter;

import javax.swing.*;

public class Rock extends Move {
    private static final String ROCK_EMOJI_PATH = "";

    public Rock(int x, int y) {
        super(ROCK_EMOJI_PATH, x, y);
    }

    @Override
    public int compareTo(Move o) {
        return 0;
    }
}

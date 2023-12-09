package move;

import java.util.Comparator;

public class MoveComparator implements Comparator<Move> {
    @Override
    public int compare(Move move1, Move move2) {
        if (move1.getClass().getName().equals(move2.getClass().getName())) {
            return 0;
        }

        if (move1 instanceof Rock) {
            if (move2 instanceof Paper) {
                return -1;
            } else if (move2 instanceof Scissor) {
                return 1;
            }
        } else if (move1 instanceof Scissor) {
            if (move2 instanceof Rock) {
                return -1;
            } else if (move2 instanceof Paper) {
                return 1;
            }
        } else if (move1 instanceof Paper) {
            if (move2 instanceof Rock) {
                return 1;
            } else if (move2 instanceof Scissor) {
                return -1;
            }
        }

        throw new IllegalArgumentException("Invalid move: " + move1);
    }
}

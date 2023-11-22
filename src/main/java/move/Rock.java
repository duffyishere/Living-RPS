package move;

public class Rock extends Move {
    private static final String UNICODE = "\uD83E\uDEA8";

    public Rock(int x, int y) {
        super(UNICODE, x, y);
    }

    @Override
    public int compareTo(Move o) {
        return 0;
    }
}

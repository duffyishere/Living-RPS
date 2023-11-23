package move;

public class Paper extends Move {
    private static final String UNICODE = "\uD83D\uDCDC";

    public Paper(int x, int y, int velX, int velY) {
        super(UNICODE, x, y, velX, velY);
    }

    @Override
    public int compareTo(Move o) {
        return 0;
    }
}

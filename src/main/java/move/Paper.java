package move;

public class Paper extends Move {
    private static final String UNICODE = "\uD83D\uDCDC";

    public Paper(Coordinate coordinate, Coordinate speed) {
        super(UNICODE, coordinate, speed);
    }

    @Override
    public int compareTo(Move o) {
        if (o instanceof Rock) return 1;
        else return 0;
    }

    @Override
    public String getUnicode() {
        return Paper.UNICODE;
    }
}

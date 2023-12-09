package move;

public class Paper extends Move {
    private static final String UNICODE = "\uD83D\uDCDC";

    public Paper(Coordinate coordinate, Coordinate speed) {
        super(UNICODE, coordinate, speed);
    }

    @Override
    public String getUnicode() {
        return Paper.UNICODE;
    }
}

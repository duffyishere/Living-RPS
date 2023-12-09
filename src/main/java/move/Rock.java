package move;

public class Rock extends Move {
    private static final String UNICODE = "\uD83E\uDEA8";

    public Rock(Coordinate coordinate, Coordinate speed) {
        super(UNICODE, coordinate, speed);
    }

    @Override
    public String getUnicode() {
        return Rock.UNICODE;
    }
}

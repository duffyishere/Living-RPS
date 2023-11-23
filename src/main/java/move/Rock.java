package move;

public class Rock extends Move {
    private static final String UNICODE = "\uD83E\uDEA8";

    public Rock(Coordinate coordinate, Coordinate speed) {
        super(UNICODE, coordinate, speed);
    }

    @Override
    public int compareTo(Move o) {
        if (o instanceof Paper) return -1;
        else return 0;
    }

    @Override
    public String getUnicode() {
        return Rock.UNICODE;
    }
}

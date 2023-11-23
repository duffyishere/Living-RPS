package move;

public class Scissor extends Move {
    private static final String UNICODE = "✄";

    public Scissor(Coordinate coordinate, Coordinate speed) {
        super(UNICODE, coordinate, speed);
    }

    @Override
    public int compareTo(Move o) {
        if (o instanceof Paper) return 1;
        else if (o instanceof Rock) return -1;
        else return 0;
    }

    @Override
    public String getUnicode() {
        return Scissor.UNICODE;
    }
}

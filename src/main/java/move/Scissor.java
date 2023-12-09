package move;

public class Scissor extends Move {
    private static final String UNICODE = "✄";

    public Scissor(Coordinate coordinate, Coordinate speed) {
        super(UNICODE, coordinate, speed);
    }

    @Override
    public String getUnicode() {
        return Scissor.UNICODE;
    }
}

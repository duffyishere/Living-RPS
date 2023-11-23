package move;

import java.util.Random;

public class Coordinate {
    public int x, y;
    private static Random random = new Random();

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinate generateRandomCoordinate(int maxX, int maxY) {
        int x = random.nextInt(maxX);
        int y = random.nextInt(maxY);
        return new Coordinate(x, y);
    }

    public static Coordinate generateRandomSpeed() {
        int velX = (random.nextInt(2) == 0) ? -2 : 2;
        int velY = (random.nextInt(2) == 0) ? -2 : 2;
        return new Coordinate(velX, velY);
    }
}

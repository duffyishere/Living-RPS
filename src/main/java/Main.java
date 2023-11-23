import javax.swing.*;

public class Main {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 800;
    public static final int INITIAL_COUNT= 50;
    public static final String TITLE = "Living RSP";

    public static void main(String[] args) {
        new Frame(TITLE, WIDTH, HEIGHT, INITIAL_COUNT);
    }
}

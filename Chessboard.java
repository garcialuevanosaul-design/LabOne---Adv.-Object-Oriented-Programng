public class Chessboard{

    public static final int MAX_ROW = 8;
    public static final int MIN_ROW = 1;

    public static boolean withinChessboard(char x, int y) {
        return x >= 'A' && x <= 'H' && y >= MIN_ROW && y <= MAX_ROW;
    }
}
public class Chessboard{
    public static boolean withinChessboard(char x, int y) {
        return x >= 'A' && x <= 'H' && y >= 1 && y <= 8;
    }
}
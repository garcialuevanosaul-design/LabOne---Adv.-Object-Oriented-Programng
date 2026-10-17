public class ChessBoard implements IntChessBoard {

    // Checks if the position is within the chessboard
    @Override
    public boolean verifyCoordinate(LocationX X, int Y) {
        return X != null && Y >= 1 && Y <= 8;
    }
}

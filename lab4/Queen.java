package lab4;

public class Queen extends Rook implements IntBishop {

    // Constructor with parameters
    public Queen(PieceType pieceName, Color pieceColor,
            LocationX start_pos_X, int start_pos_Y) {
        super(pieceName, pieceColor, start_pos_X, start_pos_Y);
    }

    // Queen can move diagonally like a Bishop
    @Override
    public boolean moveToBishop(LocationX targetX, int targetY) {

        try {
            ChessBoard board = new ChessBoard();

            if (!board.verifyCoordinate(targetX, targetY)) {
                throw new IllegalArgumentException("Invalid target position.");
            }

            int dx = Math.abs(targetX.ordinal() - getPos_X().ordinal());
            int dy = Math.abs(targetY - getPos_Y());

            return dx == dy && dx != 0;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Queen moves like a rook or bishop
    @Override
    public boolean moveTo(LocationX targetX, int targetY) {
        return super.moveTo(targetX, targetY)
                || moveToBishop(targetX, targetY);
    }

    @Override
    public String toString() {
        return "Color: " + getColor() + "\n"
                + "Position X: " + getPos_X() + "\n"
                + "Position Y: " + getPos_Y();
    }
}

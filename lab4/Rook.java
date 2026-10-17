package lab4;

public class Rook extends Figure {

    // Empty Constructor
    public Rook() {
        super();
    }

    // Constructor with parameters
    public Rook(PieceType pieceName, Color pieceColor,
            LocationX start_pos_X, int start_pos_Y) {
        super(pieceName, pieceColor, start_pos_X, start_pos_Y);
    }

    // Validates that the Rook moves along the same row or column
    @Override
    public boolean moveTo(LocationX targetX, int targetY) {

        try {
            ChessBoard board = new ChessBoard();

            if (!board.verifyCoordinate(targetX, targetY)) {
                throw new IllegalArgumentException("Invalid target position.");
            }

            int dx = Math.abs(targetX.ordinal() - getPos_X().ordinal());
            int dy = Math.abs(targetY - getPos_Y());

            return (dx == 0 || dy == 0) && (dx != 0 || dy != 0);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public String toString() {
        return "Color: " + getColor() + "\n"
                + "Position X: " + getPos_X() + "\n"
                + "Position Y: " + getPos_Y();
    }
}

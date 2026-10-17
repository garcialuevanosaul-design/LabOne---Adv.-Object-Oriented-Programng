package lab4;

public class Pawn extends Figure {

    // Empty Constructor
    public Pawn() {
        super();
    }

    // Constructor with parameters
    public Pawn(PieceType pieceName, Color pieceColor,
            LocationX start_pos_X, int start_pos_Y) {
        super(pieceName, pieceColor, start_pos_X, start_pos_Y);
    }

    // Checks if the Pawn can move to the target position
    @Override
    public boolean moveTo(LocationX targetX, int targetY) {

        try {
            ChessBoard board = new ChessBoard();

            if (!board.verifyCoordinate(targetX, targetY)) {
                throw new IllegalArgumentException("Invalid target position.");
            }

            if (targetX != getPos_X()) {
                return false;
            }

            if (getColor() == Color.WHITE) {
                return targetY == getPos_Y() + 1;
            }

            if (getColor() == Color.BLACK) {
                return targetY == getPos_Y() - 1;
            }

            return false;

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

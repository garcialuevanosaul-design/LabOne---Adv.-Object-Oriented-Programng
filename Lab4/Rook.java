class Rook extends Figure {

    // Empty Constructor
    public Rook() {
        super();
    }

    // Constructor with parameters
    public Rook(PieceType pieceName, Color pieceColor,
            LocationX start_pos_X, int start_pos_Y) {
        super(pieceName, pieceColor, start_pos_X, start_pos_Y);
    }

    // Validates that the rook moves along the same row or column
    // without staying in the same position.
    @Override
    public boolean moveTo(LocationX targetX, int targetY) {
        int dx = Math.abs(targetX.ordinal() - getPos_X().ordinal());
        int dy = Math.abs(targetY - getPos_Y());

        return (dx == 0 || dy == 0) && (dx != 0 || dy != 0);
    }

    @Override
    public String toString() {
        return "Color: " + getColor() + "\n"
                + "Position X: " + getPos_X() + "\n"
                + "Position Y: " + getPos_Y();
    }
}

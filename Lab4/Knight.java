class Knight extends Figure {

    // Empty Constructor
    public Knight() {
        super();
    }

    // Constructor with parameters
    public Knight(PieceType pieceName, Color pieceColor,
            LocationX start_pos_X, int start_pos_Y) {
        super(pieceName, pieceColor, start_pos_X, start_pos_Y);
    }

    // Validates that the knight moves in an L-shape.
    @Override
    public boolean moveTo(LocationX targetX, int targetY) {

        int dx = Math.abs(targetX.ordinal() - getPos_X().ordinal());
        int dy = Math.abs(targetY - getPos_Y());

        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }

    @Override
    public String toString() {
        return "Color: " + getColor() + "\n"
                + "Position X: " + getPos_X() + "\n"
                + "Position Y: " + getPos_Y();
    }
}

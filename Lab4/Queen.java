class Queen extends Rook implements IntBishop {

    // Constructor with parameters
    public Queen(PieceType pieceName, Color pieceColor,
            LocationX start_pos_X, int start_pos_Y) {
        super(pieceName, pieceColor, start_pos_X, start_pos_Y);
    }

    // Queen can move diagonally like a bishop
    @Override
    public boolean moveToBishop(LocationX targetX, int targetY) {
        int dx = Math.abs(targetX.ordinal() - getPos_X().ordinal());
        int dy = Math.abs(targetY - getPos_Y());

        return dx == dy && dx != 0;
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

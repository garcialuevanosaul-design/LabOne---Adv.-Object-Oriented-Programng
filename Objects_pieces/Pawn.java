class Pawn extends ChessPiece{
    // Validates that the pawn moves forward exactly one square in the same column based on its color.
    @Override
    boolean verifyMove(char targetX, int targetY) {
        if (targetX != getPos_X()) {
            return false;
        }

        if (getColor().equalsIgnoreCase("White")) {
            return targetY == getPos_Y() + 1;
        }

        if (getColor().equalsIgnoreCase("Black")) {
            return targetY == getPos_Y() - 1;
        }

        return false;
    }
}


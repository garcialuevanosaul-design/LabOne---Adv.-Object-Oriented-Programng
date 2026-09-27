class Knight extends ChessPiece{
    // Validates that the bishop moves any distance along a diagonal without staying in place.
    @Override
    boolean verifyMove(char targetX, int targetY) {

        int dx = Math.abs(targetX - getPos_X());
        int dy = Math.abs(targetY - getPos_Y());

        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}
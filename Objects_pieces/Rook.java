class Rook extends ChessPiece{
    // Validates that the rook moves any distance along the same row or column without staying in place.
    @Override
    boolean verifyMove( char targetX, int targetY) {
        int dx = Math.abs(targetX - getPos_X());
        int dy = Math.abs(targetY - getPos_Y());

        return (dx == 0 || dy == 0) && (dx != 0 || dy != 0);
    }
}
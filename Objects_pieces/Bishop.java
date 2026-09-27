class Bishop extends ChessPiece{
    @Override
    boolean verifyMove(char targetX, int targetY) {

        int dx = Math.abs(targetX - getPos_X());
        int dy = Math.abs(targetY - getPos_Y());

        return dx == dy && dx != 0;
    }
}
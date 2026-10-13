class Queen extends Bishop{
    // Constructor with parameters
    public Queen(String pieceName, String pieceColor, char start_pos_X, int start_pos_Y){
        super(pieceName,pieceColor,start_pos_X,start_pos_Y );
    }

    // The queen moves like a rook or a bishop, but not by staying in place.
    @Override
    boolean verifyMove(char targetX, int targetY) {
        int dx = Math.abs(targetX - getPos_X());
        int dy = Math.abs(targetY - getPos_Y());

        boolean movesLikeRook = (dx == 0 || dy == 0) && (dx != 0 || dy != 0);
        return super.verifyMove(targetX, targetY) || movesLikeRook;
    }
}
class Rook extends ChessPiece{
    // Empty Constructor
    public Rook(){
        super(); // Calling the ChessPiece empty constructor
    }
    // Constructor with parameters
    public Rook(String pieceName, String pieceColor, char start_pos_X, int start_pos_Y){
        super(pieceName,pieceColor,start_pos_X,start_pos_Y );
    }
    // Validates that the rook moves any distance along the same row or column without staying in place.
    @Override
    boolean verifyMove( char targetX, int targetY) {
        int dx = Math.abs(targetX - getPos_X());
        int dy = Math.abs(targetY - getPos_Y());

        return (dx == 0 || dy == 0) && (dx != 0 || dy != 0);
    }
}
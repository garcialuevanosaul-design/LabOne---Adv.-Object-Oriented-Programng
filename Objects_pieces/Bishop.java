class Bishop extends ChessPiece{
    // Empty Constructor
    public Bishop(){
        super(); // Calling the ChessPiece empty constructor
    }
    // Constructor with parameters
    public Bishop(String pieceName, String pieceColor, char start_pos_X, int start_pos_Y){
        super(pieceName,pieceColor,start_pos_X,start_pos_Y );
    }
    @Override
    boolean verifyMove(char targetX, int targetY) {

        int dx = Math.abs(targetX - getPos_X());
        int dy = Math.abs(targetY - getPos_Y());

        return dx == dy && dx != 0;
    }
}
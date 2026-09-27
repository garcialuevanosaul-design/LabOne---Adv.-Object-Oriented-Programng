class Pawn extends ChessPiece{
    // Empty Constructor
    public Pawn(){
        super(); // Calling the ChessPiece empty constructor
    }
    // Constructor with parameters
    public Pawn(String pieceName, String pieceColor, char start_pos_X, int start_pos_Y){
        super(pieceName,pieceColor,start_pos_X,start_pos_Y );
    }
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


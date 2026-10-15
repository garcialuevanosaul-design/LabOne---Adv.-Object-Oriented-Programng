class Pawn extends Figure{
    // Empty Constructor
    public Pawn(){
        super(); // Calling the Figure empty constructor
    }
    // Constructor with parameters
    public Pawn(String pieceName, String pieceColor, char start_pos_X, int start_pos_Y){
        super(pieceName,pieceColor,start_pos_X,start_pos_Y );
    }
    // Validates that the pawn moves forward exactly one square in the same column based on its color.
    @Override
    public boolean moveTo(char targetX, int targetY) {
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

    @Override
    public String toString(){
        return "Color: " + getColor() + "\n"
                + "Position X: " + getPos_X() + "\n"
                + "Position Y: " + getPos_Y();
    }
}

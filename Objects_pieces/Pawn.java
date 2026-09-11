class Pawn{

    private String name;
    private String color;
    private char pos_X;
    private int pos_Y;

    // Empty Constructor
    public Pawn(){
        name = "";
        color = "";
        pos_X = '\0';
        pos_Y = 0;
    }

    // Constructor with parameters
    public Pawn(String pieceName, String pieceColor, char start_pos_X, int start_pos_Y){
        name = pieceName;
        color = pieceColor;
        start_pos_X = pos_X;
        start_pos_Y = pos_Y;
    }

    // SETTERS
    public void setPos_X(char newPosition){
        pos_X = newPosition;
    }

    public void setPos_Y(int newPosition){
        pos_Y = newPosition;
    }

    // GETTERS
    public String getColor(){
        return color;
    }

    public char getPos_X(){
        return pos_X;
    }

    public int getPos_Y(){
        return pos_Y;
    }

    // Validates that the pawn moves forward exactly one square in the same column based on its color.
    public boolean pawnValidator(char targetX, int targetY) {
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


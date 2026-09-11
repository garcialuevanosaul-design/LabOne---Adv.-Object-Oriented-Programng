class Knight {
    private String name;
    private String color;
    private char pos_X;
    private int pos_Y;

    // Empty Constructor
    public Knight(){
        name = "";
        color = "";
        pos_X = '\0';
        pos_Y = 0;
    }

    // Constructor with parameters
    public Knight(String pieceName, String pieceColor, char start_pos_X, int start_pos_Y){
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

    // Validates that the bishop moves any distance along a diagonal without staying in place.
    public boolean knightValidator(char targetX, int targetY) {

        int dx = Math.abs(targetX - getPos_X());
        int dy = Math.abs(targetY - getPos_Y());

        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}
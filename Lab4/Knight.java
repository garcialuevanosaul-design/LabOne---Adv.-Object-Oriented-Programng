class Knight extends Figure{
    // Empty Constructor
    public Knight(){
        super(); // Calling the Figure empty constructor
    }
    // Constructor with parameters
    public Knight(String pieceName, String pieceColor, char start_pos_X, int start_pos_Y){
        super(pieceName,pieceColor,start_pos_X,start_pos_Y );
    }
    // Validates that the bishop moves any distance along a diagonal without staying in place.
    @Override
    public boolean moveTo(char targetX, int targetY) {

        int dx = Math.abs(targetX - getPos_X());
        int dy = Math.abs(targetY - getPos_Y());

        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }

    @Override
    public String toString(){
        return "Color: " + getColor() + "\n"
                + "Position X: " + getPos_X() + "\n"
                + "Position Y: " + getPos_Y();
    }
}
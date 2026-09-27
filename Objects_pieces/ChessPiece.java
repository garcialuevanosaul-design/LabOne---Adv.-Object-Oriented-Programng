abstract class ChessPiece{
    private String name;
    private String color;
    private char pos_X;
    private int pos_Y;

    // Empty Constructor
    public ChessPiece(){
        name = "";
        color = "";
        pos_X = '\0';
        pos_Y = 0;
    }

    // Constructor with parameters
    public ChessPiece(String pieceName, String pieceColor, char start_pos_X, int start_pos_Y){
        this.name = pieceName;
        this.color = pieceColor;
        this.pos_X = start_pos_X;
        this.pos_Y = start_pos_Y;
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

    // Abstract method
    abstract boolean verifyMove(char targetX, int targetY);
}
class Bishop implements IntBishop{
    private String color;
    private char pos_X;
    private int pos_Y;

    // Empty Constructor
    public Bishop(){}

    public Bishop(String pieceColor, char start_pos_X, int start_pos_Y){
        this.color = pieceColor;
        this.pos_X = start_pos_X;
        this.pos_Y = start_pos_Y;
    }

    // SETTERS

    public void setColor(String newColor){
        color = newColor;
    }

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

    @Override
    public String toString(){
        return "Color: " + getColor() + "\n"
                + "Position X: " + getPos_X() + "\n"
                + "Position Y: " + getPos_Y();
    }

    @Override
    public boolean moveToBishop(char targetX, int targetY) {
        int dx = Math.abs(targetX - getPos_X());
        int dy = Math.abs(targetY - getPos_Y());

        return dx == dy && dx != 0;
    }
}
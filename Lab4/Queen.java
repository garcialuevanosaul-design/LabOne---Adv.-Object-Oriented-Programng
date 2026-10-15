class Queen extends Rook implements IntBishop{
    // Constructor with parameters
    public Queen(String pieceName, String pieceColor, char start_pos_X, int start_pos_Y){
        super(pieceName,pieceColor,start_pos_X,start_pos_Y );
    }

    @Override
    public boolean moveToBishop(char targetX, int targetY) {
        int dx = Math.abs(targetX - getPos_X());
        int dy = Math.abs(targetY - getPos_Y());

        return dx == dy && dx != 0;
    }
    // The queen moves like a rook or a bishop, but not by staying in place.
    @Override
    public boolean moveTo(char targetX, int targetY) {
        return super.moveTo(targetX, targetY) || moveToBishop(targetX, targetY);
    }

    @Override
    public String toString(){
        return "Color: " + getColor() + "\n"
                + "Position X: " + getPos_X() + "\n"
                + "Position Y: " + getPos_Y();
    }
}
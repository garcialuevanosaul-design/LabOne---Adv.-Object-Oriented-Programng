class King extends Queen{
    // Constructor with parameters
    public King(String pieceName, String pieceColor, char start_pos_X, int start_pos_Y){
        super(pieceName,pieceColor,start_pos_X,start_pos_Y );
    }

    // The king moves exactly one square in any direction.
    @Override
    public boolean moveTo(char targetX, int targetY) {
        int dx = Math.abs(targetX - getPos_X());
        int dy = Math.abs(targetY - getPos_Y());

        return super.moveTo(targetX, targetY)
                && dx <= 1
                && dy <= 1;
    }

    @Override
    public String toString(){
        return "Color: " + getColor() + "\n"
                + "Position X: " + getPos_X() + "\n"
                + "Position Y: " + getPos_Y();
    }
}
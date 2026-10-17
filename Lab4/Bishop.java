class Bishop implements IntBishop {
    private Color color;
    private LocationX pos_X;
    private int pos_Y;

    // Empty Constructor
    public Bishop() {
    }

    // Constructor with parameters
    public Bishop(Color pieceColor, LocationX start_pos_X, int start_pos_Y) {
        this.color = pieceColor;
        this.pos_X = start_pos_X;
        this.pos_Y = start_pos_Y;
    }

    // SETTERS
    public void setColor(Color newColor) {
        color = newColor;
    }

    public void setPos_X(LocationX newPosition) {
        pos_X = newPosition;
    }

    public void setPos_Y(int newPosition) {
        pos_Y = newPosition;
    }

    // GETTERS
    public Color getColor() {
        return color;
    }

    public LocationX getPos_X() {
        return pos_X;
    }

    public int getPos_Y() {
        return pos_Y;
    }

    // Bishop moves diagonally
    @Override
    public boolean moveToBishop(LocationX targetX, int targetY) {
        int dx = Math.abs(targetX.ordinal() - getPos_X().ordinal());
        int dy = Math.abs(targetY - getPos_Y());

        return dx == dy && dx != 0;
    }

    @Override
    public String toString() {
        return "Color: " + getColor() + "\n"
                + "Position X: " + getPos_X() + "\n"
                + "Position Y: " + getPos_Y();
    }
}

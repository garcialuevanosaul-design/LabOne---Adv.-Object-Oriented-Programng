public abstract class Figure implements IntFigure {
    private PieceType name;
    private Color color;
    private LocationX pos_X;
    private int pos_Y;

    // Empty Constructor
    public Figure() {
        name = null;
        color = null;
        pos_X = null;
        pos_Y = 0;
    }

    // Constructor with parameters
    public Figure(PieceType pieceName, Color pieceColor,
            LocationX start_pos_X, int start_pos_Y) {
        this.name = pieceName;
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

    public PieceType getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public LocationX getPos_X() {
        return pos_X;
    }

    public int getPos_Y() {
        return pos_Y;
    }
}

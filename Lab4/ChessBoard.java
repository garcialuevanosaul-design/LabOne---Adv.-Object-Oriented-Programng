class ChessBoard implements IntChessBoard{

    public static final int MAX_ROW = 8;
    public static final int MIN_ROW = 1;
    @Override
    public boolean verifyCoordinate(char X, int Y){
        return X >= 'A' && X <= 'H' && Y >= MIN_ROW && Y <= MAX_ROW;
    }
}
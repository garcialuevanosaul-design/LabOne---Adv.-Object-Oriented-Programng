import java.util.Scanner;

public class LabThree {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ChessPiece[] pieces = new ChessPiece[6];
        String[] pieceNames = {
                "PAWN", "ROOK", "KNIGHT", "BISHOP", "QUEEN", "KING"
        };

        // Creates the six chess pieces
        for (int i = 0; i < pieces.length; i++) {

            String pieceName = pieceNames[i];

            System.out.println("Enter information for " + pieceName);

            // Gets the piece color
            String color = "";

            while (!color.equals("WHITE") && !color.equals("BLACK")) {
                System.out.print("Enter piece color (WHITE or BLACK): ");
                color = input.nextLine().toUpperCase();

                if (!color.equals("WHITE") && !color.equals("BLACK")) {
                    System.out.println("Invalid color. Please try again.");
                }
            }

            // Gets the starting position
            char column = ' ';
            int row = 0;

            while (!Chessboard.withinChessboard(column, row)) {

                System.out.print("Enter current column (a-h): ");
                String columnInput = input.nextLine().toUpperCase();

                if (columnInput.length() == 1) {
                    column = columnInput.charAt(0);
                } else {
                    column = ' ';
                }

                System.out.print("Enter current row (1-8): ");

                if (input.hasNextInt()) {
                    row = input.nextInt();
                    input.nextLine();
                } else {
                    input.nextLine();
                    row = 0;
                }

                if (!Chessboard.withinChessboard(column, row)) {
                    System.out.println("Invalid position. Please try again.");
                }
            }

            // Creates the correct chess piece
            if (pieceName.equals("PAWN")) {
                pieces[i] = new Pawn(pieceName, color, column, row);
            } else if (pieceName.equals("ROOK")) {
                pieces[i] = new Rook(pieceName, color, column, row);
            } else if (pieceName.equals("KNIGHT")) {
                pieces[i] = new Knight(pieceName, color, column, row);
            } else if (pieceName.equals("BISHOP")) {
                pieces[i] = new Bishop(pieceName, color, column, row);
            } else if (pieceName.equals("QUEEN")) {
                pieces[i] = new Queen(pieceName, color, column, row);
            } else if (pieceName.equals("KING")) {
                pieces[i] = new King(pieceName, color, column, row);
            }
        }

        // Gets the target position
        char targetColumn = ' ';
        int targetRow = 0;

        while (!Chessboard.withinChessboard(targetColumn, targetRow)) {

            System.out.print("Enter target column (a-h): ");
            String targetInput = input.nextLine().toUpperCase();

            if (targetInput.length() == 1) {
                targetColumn = targetInput.charAt(0);
            } else {
                targetColumn = ' ';
            }

            System.out.print("Enter target row (1-8): ");

            if (input.hasNextInt()) {
                targetRow = input.nextInt();
                input.nextLine();
            } else {
                input.nextLine();
                targetRow = 0;
            }

            if (!Chessboard.withinChessboard(targetColumn, targetRow)) {
                System.out.println("Invalid position. Please try again.");
            }
        }

        // Traverses the array using polymorphism
        for (int i = 0; i < pieces.length; i++) {

            ChessPiece piece = pieces[i];

            if (piece.verifyMove(targetColumn, targetRow)) {
                System.out.println(
                        pieceNames[i] + " at "
                                + piece.getPos_X() + "," + piece.getPos_Y()
                                + " can move to "
                                + targetColumn + "," + targetRow);
            } else {
                System.out.println(
                        pieceNames[i] + " at "
                                + piece.getPos_X() + "," + piece.getPos_Y()
                                + " can NOT move to "
                                + targetColumn + "," + targetRow);
            }
        }

        input.close();
    }
}

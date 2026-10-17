import java.util.Scanner;
import lab4.*;

public class LabFour {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Array of chess pieces (Bishop is separate)
        Figure[] pieces = new Figure[5];

        PieceType[] pieceNames = {
                PieceType.PAWN,
                PieceType.ROOK,
                PieceType.KNIGHT,
                PieceType.QUEEN,
                PieceType.KING
        };

        ChessBoard board = new ChessBoard();

        Bishop bishop = null;

        // Getting information for each chess piece
        for (int i = 0; i < pieces.length; i++) {

            // Get Bishop information after Knight
            if (i == 3) {

                System.out.println("Enter information for BISHOP");

                Color bishopColor = null;

                while (bishopColor == null) {
                    System.out.print("Enter piece color (WHITE or BLACK): ");
                    String colorInput = input.nextLine().toUpperCase();

                    try {
                        bishopColor = Color.valueOf(colorInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid color. Please try again.");
                    }
                }

                // Get Bishop's starting position
                LocationX bishopColumn = null;
                int bishopRow = 0;
                boolean validBishopPosition = false;

                while (!validBishopPosition) {

                    System.out.print("Enter current column (A-H): ");
                    String columnInput = input.nextLine().toUpperCase();

                    try {
                        bishopColumn = LocationX.valueOf(columnInput);
                    } catch (IllegalArgumentException e) {
                        bishopColumn = null;
                    }

                    System.out.print("Enter current row (1-8): ");
                    String rowInput = input.nextLine();

                    try {
                        bishopRow = Integer.parseInt(rowInput);

                        if (!board.verifyCoordinate(bishopColumn, bishopRow)) {
                            throw new InvalidCoordinateException("Invalid position.");
                        }

                        validBishopPosition = true;

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid row. Please enter a number.");
                    } catch (InvalidCoordinateException e) {
                        System.out.println(e.getMessage() + " Please try again.");
                    }
                }

                // Create Bishop separately from the Figure array
                bishop = new Bishop(bishopColor, bishopColumn, bishopRow);
            }

            PieceType pieceName;

            try {
                pieceName = checkPieceName(pieceNames[i].name());
            } catch (InvalidPieceException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("Enter information for " + pieceName);

            // Getting the piece color
            Color color = null;

            while (color == null) {
                System.out.print("Enter piece color (WHITE or BLACK): ");
                String colorInput = input.nextLine().toUpperCase();

                try {
                    color = Color.valueOf(colorInput);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid color. Please try again.");
                }
            }

            // Get the starting position
            LocationX column = null;
            int row = 0;
            boolean validPosition = false;

            while (!validPosition) {

                System.out.print("Enter current column (A-H): ");
                String columnInput = input.nextLine().toUpperCase();

                try {
                    column = LocationX.valueOf(columnInput);
                } catch (IllegalArgumentException e) {
                    column = null;
                }

                System.out.print("Enter current row (1-8): ");
                String rowInput = input.nextLine();

                try {
                    row = Integer.parseInt(rowInput);

                    if (!board.verifyCoordinate(column, row)) {
                        throw new InvalidCoordinateException("Invalid position.");
                    }

                    validPosition = true;

                } catch (NumberFormatException e) {
                    System.out.println("Invalid row. Please enter a number.");
                } catch (InvalidCoordinateException e) {
                    System.out.println(e.getMessage() + " Please try again.");
                }
            }

            // Create the correct chess piece
            if (pieceName == PieceType.PAWN) {
                pieces[i] = new Pawn(pieceName, color, column, row);

            } else if (pieceName == PieceType.ROOK) {
                pieces[i] = new Rook(pieceName, color, column, row);

            } else if (pieceName == PieceType.KNIGHT) {
                pieces[i] = new Knight(pieceName, color, column, row);

            } else if (pieceName == PieceType.QUEEN) {
                pieces[i] = new Queen(pieceName, color, column, row);

            } else if (pieceName == PieceType.KING) {
                pieces[i] = new King(pieceName, color, column, row);
            }
        }

        // Get the target position
        LocationX targetColumn = null;
        int targetRow = 0;
        boolean validTarget = false;

        while (!validTarget) {

            System.out.print("Enter target column (A-H): ");
            String targetInput = input.nextLine().toUpperCase();

            try {
                targetColumn = LocationX.valueOf(targetInput);
            } catch (IllegalArgumentException e) {
                targetColumn = null;
            }

            System.out.print("Enter target row (1-8): ");
            String rowInput = input.nextLine();

            try {
                targetRow = Integer.parseInt(rowInput);

                if (!board.verifyCoordinate(targetColumn, targetRow)) {
                    throw new InvalidCoordinateException("Invalid target position.");
                }

                validTarget = true;

            } catch (NumberFormatException e) {
                System.out.println("Invalid row. Please enter a number.");
            } catch (InvalidCoordinateException e) {
                System.out.println(e.getMessage() + " Please try again.");
            }
        }

        // Check all six chess pieces' movements
        for (int i = 0; i < pieces.length; i++) {

            // Test Bishop between Knight and Queen
            if (i == 3) {

                if (bishop.moveToBishop(targetColumn, targetRow)) {
                    System.out.println(
                            "BISHOP at " + bishop.getPos_X() + "," + bishop.getPos_Y()
                                    + " can move to "
                                    + targetColumn + "," + targetRow);
                } else {
                    System.out.println(
                            "BISHOP at " + bishop.getPos_X() + "," + bishop.getPos_Y()
                                    + " can NOT move to "
                                    + targetColumn + "," + targetRow);
                }
            }

            // Test the other five pieces using polymorphism
            Figure piece = pieces[i];

            if (piece.moveTo(targetColumn, targetRow)) {
                System.out.println(
                        piece.getName() + " at "
                                + piece.getPos_X() + "," + piece.getPos_Y()
                                + " can move to "
                                + targetColumn + "," + targetRow);
            } else {
                System.out.println(
                        piece.getName() + " at "
                                + piece.getPos_X() + "," + piece.getPos_Y()
                                + " can NOT move to "
                                + targetColumn + "," + targetRow);
            }
        }

        input.close();
    }

    public static PieceType checkPieceName(String name)
            throws InvalidPieceException {

        try {
            return PieceType.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidPieceException("Invalid chess piece: " + name);
        }
    }

}

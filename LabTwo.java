import java.util.Scanner;

public class LabTwo {

    enum PieceType {
        PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String anotherPiece = "YES";

        while (anotherPiece.equalsIgnoreCase("YES")) {
            PieceType pieceType = null;

            while (pieceType == null) {
                System.out.println("Select a chess piece (PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING): ");
                String pieceInput = input.nextLine().toUpperCase();

                try {
                    pieceType = PieceType.valueOf(pieceInput);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid chess piece. Please try again.");
                }
            }

            String color = "";

            while (!color.equals("WHITE") && !color.equals("BLACK")) {
                System.out.println("Enter piece color (WHITE or BLACK): ");
                color = input.nextLine().toUpperCase();

                if (!color.equals("WHITE") && !color.equals("BLACK")) {
                    System.out.println("Invalid color. Please try again.");
                }
            }

            String currentColumnInput = "";

            while (currentColumnInput.length() != 1) {
                System.out.println("Enter current column (a-h): ");
                currentColumnInput = input.nextLine().toUpperCase();

                if (currentColumnInput.length() != 1) {
                    System.out.println("Invalid column. Please enter one letter.");
                }
            }

            char currentColumn = currentColumnInput.charAt(0);

            int currentRow = 0;

            while (currentRow < 1 || currentRow > 8) {
                System.out.println("Enter current row (1-8): ");

                if (input.hasNextInt()) {
                    currentRow = input.nextInt();
                    input.nextLine();

                    if (currentRow < 1 || currentRow > 8) {
                        System.out.println("Invalid row. Please enter a number from 1-8.");
                    }
                } else {
                    System.out.println("Invalid row. Please enter a number from 1-8.");
                    input.nextLine();
                }
            }

            while (!Chessboard.withinChessboard(currentColumn, currentRow)) {
                System.out.println("Invalid position. Column must be a-h and row must be 1-8.");

                System.out.println("Enter current column (a-h): ");
                currentColumn = input.nextLine().toUpperCase().charAt(0);

                System.out.println("Enter current row (1-8): ");
                currentRow = input.nextInt();
                input.nextLine();
            }

            String anotherTarget = "YES";

            while (anotherTarget.equalsIgnoreCase("YES")) {
                String targetColumnInput = "";

                while (targetColumnInput.length() != 1) {
                    System.out.println("Enter target column (a-h): ");
                    targetColumnInput = input.nextLine().toUpperCase();

                    if (targetColumnInput.length() != 1) {
                        System.out.println("Invalid column. Please enter one letter.");
                    }
                }

                char targetColumn = targetColumnInput.charAt(0);

                int targetRow = 0;

                while (targetRow < 1 || targetRow > 8) {
                    System.out.println("Enter target row (1-8): ");

                    if (input.hasNextInt()) {
                        targetRow = input.nextInt();
                        input.nextLine();

                        if (targetRow < 1 || targetRow > 8) {
                            System.out.println("Invalid row. Please enter a number from 1-8.");
                        }
                    } else {
                        System.out.println("Invalid row. Please enter a number from 1-8.");
                        input.nextLine();
                    }
                }

                while (!Chessboard.withinChessboard(targetColumn, targetRow)) {
                    System.out.println("Invalid position. Column must be a-h and row must be 1-8.");

                    System.out.println("Enter target column (a-h): ");
                    targetColumn = input.nextLine().toUpperCase().charAt(0);

                    System.out.println("Enter target row (1-8): ");
                    targetRow = input.nextInt();
                    input.nextLine();
                }

                while (targetColumn == currentColumn && targetRow == currentRow) {
                    System.out.println("Target position cannot be the same as the current position.");

                    targetColumnInput = "";

                    while (targetColumnInput.length() != 1) {
                        System.out.println("Enter target column (a-h): ");
                        targetColumnInput = input.nextLine().toUpperCase();

                        if (targetColumnInput.length() != 1) {
                            System.out.println("Invalid column. Please enter one letter.");
                        }
                    }

                    targetColumn = targetColumnInput.charAt(0);

                    targetRow = 0;

                    while (targetRow < 1 || targetRow > 8) {
                        System.out.println("Enter target row (1-8): ");

                        if (input.hasNextInt()) {
                            targetRow = input.nextInt();
                            input.nextLine();

                            if (targetRow < 1 || targetRow > 8) {
                                System.out.println("Invalid row. Please enter a number from 1-8.");
                            }
                        } else {
                            System.out.println("Invalid row. Please enter a number from 1-8.");
                            input.nextLine();
                        }
                    }
                }

                if (pieceType == PieceType.PAWN) {
                    Pawn pawn = new Pawn("PAWN", color, currentColumn, currentRow);
                    boolean validMove = pawn.pawnValidator(targetColumn, targetRow);

                    if (validMove) {
                        System.out.println("PAWN can move to " + targetColumn + targetRow);
                    } else {
                        System.out.println("PAWN cannot move to " + targetColumn + targetRow);
                    }
                } else if (pieceType == PieceType.ROOK) {
                    Rook rook = new Rook("ROOK", color, currentColumn, currentRow);
                    boolean validMove = rook.rookValidator(targetColumn, targetRow);

                    if (validMove) {
                        System.out.println("ROOK can move to " + targetColumn + targetRow);
                    } else {
                        System.out.println("ROOK cannot move to " + targetColumn + targetRow);
                    }
                } else if (pieceType == PieceType.KNIGHT) {
                    Knight knight = new Knight("KNIGHT", color, currentColumn, currentRow);
                    boolean validMove = knight.knightValidator(targetColumn, targetRow);

                    if (validMove) {
                        System.out.println("KNIGHT can move to " + targetColumn + targetRow);
                    } else {
                        System.out.println("KNIGHT cannot move to " + targetColumn + targetRow);
                    }
                } else if (pieceType == PieceType.BISHOP) {
                    Bishop bishop = new Bishop("BISHOP", color, currentColumn, currentRow);
                    boolean validMove = bishop.bishopValidator(targetColumn, targetRow);

                    if (validMove) {
                        System.out.println("BISHOP can move to " + targetColumn + targetRow);
                    } else {
                        System.out.println("BISHOP cannot move to " + targetColumn + targetRow);
                    }
                } else if (pieceType == PieceType.QUEEN) {
                    Queen queen = new Queen("QUEEN", color, currentColumn, currentRow);
                    boolean validMove = queen.queenValidator(targetColumn, targetRow);

                    if (validMove) {
                        System.out.println("QUEEN can move to " + targetColumn + targetRow);
                    } else {
                        System.out.println("QUEEN cannot move to " + targetColumn + targetRow);
                    }
                } else if (pieceType == PieceType.KING) {
                    King king = new King("KING", color, currentColumn, currentRow);
                    boolean validMove = king.kingValidator(targetColumn, targetRow);

                    if (validMove) {
                        System.out.println("KING can move to " + targetColumn + targetRow);
                    } else {
                        System.out.println("KING cannot move to " + targetColumn + targetRow);
                    }
                }

                System.out.println("Verify another target position using the same original position? (YES/NO): ");
                anotherTarget = input.nextLine().toUpperCase();
                while (!anotherTarget.equals("YES") && !anotherTarget.equals("NO")) {
                    System.out.println("Invalid input. Please enter YES or NO.");
                    System.out.println("Verify another target position using the same original position? (YES/NO): ");
                    anotherTarget = input.nextLine().toUpperCase();
                }

            }
            System.out.println("Would you like to select another chess piece? (YES/NO): ");
            anotherPiece = input.nextLine().toUpperCase();
            while (!anotherPiece.equals("YES") && !anotherPiece.equals("NO")) {
                System.out.println("Invalid input. Please enter YES or NO.");
                System.out.println("Would you like to select another chess piece? (YES/NO): ");
                anotherPiece = input.nextLine().toUpperCase();
            }
        }
    }
}

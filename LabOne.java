import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LabOne {

    public static class ChessPiece {
        public String name;
        public String color;
        public char pos_X;
        public int pos_Y;
    }

    public static boolean positionValidator(char x, int y) {
        return x >= 'A' && x <= 'H' && y >= 1 && y <= 8;
    }

    public static boolean kingValidator(ChessPiece piece, char targetX, int targetY) {
        if (!positionValidator(piece.pos_X, piece.pos_Y) ||
        !positionValidator(targetX, targetY)) {
        return false;
        }

        int dx = Math.abs(targetX - piece.pos_X);
        int dy = Math.abs(targetY - piece.pos_Y);

        return dx <= 1 && dy <= 1 && (dx != 0 || dy != 0);
    }

    public static boolean rookValidator(ChessPiece piece, char targetX, int targetY) {
        if (!positionValidator(piece.pos_X, piece.pos_Y) || !positionValidator(targetX, targetY)) {

            return false;
        }

        int dx = Math.abs(targetX - piece.pos_X);
        int dy = Math.abs(targetY - piece.pos_Y);

        return (dx == 0 || dy == 0) && (dx != 0 || dy != 0);
    }

    public static boolean queenValidator(ChessPiece piece, char targetX, int targetY) {
        if (!positionValidator(piece.pos_X, piece.pos_Y) ||
            !positionValidator(targetX, targetY)) {
            return false;
        }

        int dx = Math.abs(targetX - piece.pos_X);
        int dy = Math.abs(targetY - piece.pos_Y);

        return ((dx == 0 || dy == 0) || dx == dy)
                && (dx != 0 || dy != 0);
    }

    public static boolean knightValidator(ChessPiece piece, char targetX, int targetY) {
        if (!positionValidator(piece.pos_X, piece.pos_Y) ||
            !positionValidator(targetX, targetY)) {
            return false;
        }

        int dx = Math.abs(targetX - piece.pos_X);
        int dy = Math.abs(targetY - piece.pos_Y);

        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }

    public static boolean bishopValidator(ChessPiece piece, char targetX, int targetY) {
        if (!positionValidator(piece.pos_X, piece.pos_Y) ||
            !positionValidator(targetX, targetY)) {
            return false;
        }

        int dx = Math.abs(targetX - piece.pos_X);
        int dy = Math.abs(targetY - piece.pos_Y);

        return dx == dy && dx != 0;
    }


    public static boolean pawnValidator(ChessPiece piece, char targetX, int targetY) {
        if (!positionValidator(piece.pos_X, piece.pos_Y) ||
            !positionValidator(targetX, targetY)) {
            return false;
        }

        if (targetX != piece.pos_X) {
            return false;
        }

        if (piece.color.equalsIgnoreCase("White")) {
            return targetY == piece.pos_Y + 1;
        }

        if (piece.color.equalsIgnoreCase("Black")) {
            return targetY == piece.pos_Y - 1;
        }

        return false;
    }

    // Printing Verification:
    // Prints whether each chess piece can or cannot move to the target position
    public static void printVerification(ChessPiece piece, char targetX, int targetY, boolean validMove) {
        if (validMove) {
            System.out.println(piece.name + " at " + piece.pos_X + ", " + piece.pos_Y + " can move to " + targetX + ", " + targetY);
        } else {
            System.out.println(piece.name + " at " + piece.pos_X + ", " + piece.pos_Y + " can NOT move to " + targetX + ", " + targetY);
        }
    }

    public static void main(String[] args) {
        List<ChessPiece> chessList = new ArrayList<>(); // I decide to use an ArrayList because it's dynamic
        File file = new File("chess.txt");
        Scanner userInput = new Scanner(System.in);

        // Scanner Section:
        // It has 2 scanners: the first one reads each line, and the second one reads
        // the line to be able to separate it by commas using a delimiter.
        // It then reads each section of the line, and assign each attribute of the
        // chessPiece object to it, then adds the object to chessList
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                try (Scanner rowScanner = new Scanner(line)) {
                    rowScanner.useDelimiter("\\s*,\\s*");

                    if (rowScanner.hasNext()) {
                        ChessPiece piece = new ChessPiece();

                        piece.name = rowScanner.next();
                        piece.color = rowScanner.next();
                        piece.pos_X = Character.toUpperCase(rowScanner.next().charAt(0));
                        piece.pos_Y = rowScanner.nextInt();

                        chessList.add(piece);
                    }
                }
            }
            System.out.print("Enter a position to move (e.g. E,1): ");
            userInput.useDelimiter("\\s*,\\s*|\\s+");

            char pos_x = Character.toUpperCase(userInput.next().charAt(0));
            int pos_y = userInput.nextInt();

            for (ChessPiece piece : chessList) {
                if(piece.name.equalsIgnoreCase("king")){
                    boolean is_valid = kingValidator(piece, pos_x, pos_y);
                    printVerification(piece, pos_x, pos_y, is_valid);

                }else if(piece.name.equalsIgnoreCase("rook")){
                    boolean is_valid = rookValidator(piece, pos_x, pos_y);
                    printVerification(piece, pos_x, pos_y, is_valid); 

                }else if(piece.name.equalsIgnoreCase("queen")){
                    boolean is_valid = queenValidator(piece, pos_x, pos_y);
                    printVerification(piece, pos_x, pos_y, is_valid); 

                }else if(piece.name.equalsIgnoreCase("bishop")){
                    boolean is_valid = bishopValidator(piece, pos_x, pos_y);
                    printVerification(piece, pos_x, pos_y, is_valid);

                }else if(piece.name.equalsIgnoreCase("pawn")){
                    boolean is_valid = pawnValidator(piece, pos_x, pos_y);
                    printVerification(piece, pos_x, pos_y, is_valid);   

                }else if(piece.name.equalsIgnoreCase("knight")){
                    boolean is_valid = knightValidator(piece, pos_x, pos_y);
                    printVerification(piece, pos_x, pos_y, is_valid);                    
                }
            }
            

        } catch (FileNotFoundException e) {
            System.out.println("Error: The file could not be found.");
        }
    }

}

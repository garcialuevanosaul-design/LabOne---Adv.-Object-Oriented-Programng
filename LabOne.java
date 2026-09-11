// TEAM: Saul Garcia, Pablo Campos, Abdullah Abdmahdi
// This is a small Chess Piece move validator. It reads a file with pieces, ask the user to input a move, and 
// validate each piece

// Log History
// Change-1: Create the scanner and object
// Change-2: Created the print verificator
// Change-3: Added the logic for each piece
// Change-4: Added the for loop to check the move input
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LabOne {

    // Printing Verification:
    // Prints whether each chess piece can or cannot move to the target position


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

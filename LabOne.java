import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LabOne{

    public static class ChessPiece{
        public String name;
        public String color;
        public char pos_X;
        public int pos_Y;
    }

    public static boolean kingValidator(char pos_x, int pos_y){
        // Logic
    }

    public static boolean rookValidator(char pos_x, int pos_y){
        // Logic
    }

    public static boolean queenValidator(char pos_x, int pos_y){
        // Logic
    }

    public static boolean bishopValidator(char pos_x, int pos_y){
        // Logic
    }

    public static boolean knightValidator(char pos_x, int pos_y){
        // Logic
    }

    public static boolean pawnValidator(char pos_x, int pos_y){
        // Logic
    }
    public static void main(String[] args){
        List<ChessPiece> chessList = new ArrayList<>(); // I decide to use an ArrayList because it's dynamic
        File file = new File("chess.txt");
        Scanner userInput = new Scanner(System.in);

        // Scanner Section:
        // It has 2 scanners: the first one reads each line, and the second one reads the line to be able to separate it by commas using a delimiter.
        // It then reads each section of the line, and assign each attribute of the chessPiece object to it, then adds the object to chessList
        try(Scanner fileScanner = new Scanner(file)){
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                try(Scanner rowScanner = new Scanner(line)){
                    rowScanner.useDelimiter("\\s*,\\s*");

                    if (rowScanner.hasNext()){
                        ChessPiece piece = new ChessPiece();

                        piece.name = rowScanner.next();
                        piece.color = rowScanner.next();
                        piece.pos_X = rowScanner.next().charAt(0);
                        piece.pos_Y = rowScanner.nextInt();

                        chessList.add(piece);
                    }
                }
            }
            System.out.print("Enter a position to move (e.g. E,1): ");
            userInput.useDelimiter(",");

            char pos_x = userInput.next().charAt(0);
            int age = userInput.nextInt();



        }catch (FileNotFoundException e) {
            System.out.println("Error: The file could not be found.");
        }
    }

}

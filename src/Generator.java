import java.util.*;

public final class Generator {
    private static Board availableBoard = new Board();

    // Returns true if entry is unique in row, column and 3x3-block
    static boolean checkEntry(int entryRow, int entryColumn, Board board){
        // Checks if entry is unique in row
        for(int i = 0; i < 9; i++){
            if(i != entryColumn){
                if(board.getValueAt(i, entryRow) == board.getValueAt(entryColumn, entryRow)){
                    return false;
                }
            }
        }

        // Checks if entry is unique in column
        for(int i = 0; i < 9; i++){
            if(i != entryRow){
                if(board.getValueAt(entryColumn, i) == board.getValueAt(entryColumn, entryRow)){
                    return false;
                }
            }
        }

        // Getting which block entry is a part of
        int blockRow = (int)(Math.floor(entryRow / 3));
        int blockColumn = (int)(Math.floor(entryColumn / 3));

        // Checks if entry is unique in 3x3-block
        for(int i = blockRow; i < 3; i++){
            for(int j = blockColumn; j < 3; j++){
                if(i != entryRow && j != entryColumn){
                    if(board.getValueAt(j, i) == board.getValueAt(entryColumn, entryRow)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static int fill(Board board){
        board.reset();
        // Loops through the numbers going into the array from 1 till 9 included
        // Uses 'n' as iterator for 'number'
        for(int n = 1; n <= 9; n++){
            availableBoard.fillWithPlaceHolders();
            // 'i' is current row
            for(int i = 0; i < 9; i++){
                ArrayList<Integer> availableColumns = availableBoard.getColumns(i);
                // Next two lines makes sure the next numbers does not overwrite other filled in numbers
                ArrayList<Integer> preFilled = board.getColumns(i);
                availableColumns.removeIf(e -> preFilled.contains(e));

                // Exits function in case no columns are available
                if (availableColumns.size() == 0) {
                    return -1;
                }

                int randIndex;
                randIndex = new Random().nextInt(availableColumns.size());
                board.addEntry(availableColumns.get(randIndex), i, n);


                // Makes column at 'randIndex' unavailable until 'n' increments
                availableBoard.emptyColumn(availableColumns.get(randIndex));
                // Makes columns in the same block as (randIndex, i) unavailable
                availableBoard.emptyBlockAt(availableColumns.get(randIndex), i);
            }
        }
        return 0;
    }

    static void generate(Board board){
        boolean boardInProgress = true;
        // Continues until valid board emerges
        while(boardInProgress) {
            if(Generator.fill(board) == 0){
                boardInProgress = false;
            }
        }
        Generator.pop(board);
    }

    // int difficulty must be between 0 and 61
    private static void pop(Board board){
        int remainingNumbers = 81;
        int input;
        System.out.println("Enter how many numbers you want to start out with (minimum of 20 and maximum of 81):");
        while(true){
            // Handles when user enters something thats not a valid Integer-object
            try {
                input = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid integer within the given range");
                continue;
            }

            // Makes sure the integer is within my given range
            if(20 <= input && input <= 81){
                break;
            } else {
                System.out.println("Please enter an integer that is between 20 and 81 both included");
            }
        }

        while(remainingNumbers > input){
            int randCol = new Random().nextInt(9);
            int randRow = new Random().nextInt(9);

            if(!board.isEmpty(randCol, randRow)){
                board.addEntry(randCol, randRow, -1);
                remainingNumbers--;
            }
        }
    }
}

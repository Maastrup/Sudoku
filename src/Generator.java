import java.util.*;

public final class Generator {
    static Board availableBoard = new Board();

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

    // TODO: fix numbers being placed in taken squares with availableBoard buffer array
    static void generate(Board board) throws Exception {
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

                // Throws exception if no columns are available
                if (availableColumns.size() == 0) {
                    throw new Exception();
                }

                int randIndex;
                randIndex = new Random().nextInt(availableColumns.size());
                board.addEntry(availableColumns.get(randIndex), i, n);


                // Makes column at 'randIndex' unavailable until 'n' increments
                availableBoard.emptyColumn(availableColumns.get(randIndex));
                // Makes columns in the same block as (randIndex, i) unavailable
                // TODO: numbers can end up in same block - fix please
                availableBoard.emptyBlockAt(availableColumns.get(randIndex), i);
            }
        }
        /*
        for(int i = 1; i < 10; i++){
            List<Integer> availableColumns = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8));
            List<Integer> blockBuffer = new ArrayList<>(availableColumns);

            for(int j = 0; j < 9; j++){
                if(j % 3 == 0){
                    blockBuffer = new ArrayList<>(availableColumns);
                }


                int columnIndex = new Random().nextInt(blockBuffer.size());

                Board.addEntry(blockBuffer.get(columnIndex), j, i);
                // Removes the column where entry was added from possible columns
                availableColumns.remove(blockBuffer.get(columnIndex));

                // Removes columns in the block where entry was added from possible columns
                switch (blockBuffer.get(columnIndex) / 3){
                    case 0:
                        for(int k = 0; k < 3; k++) {
                            // the 'final' statement is redundant here, but I left in
                            // because it shows why k can't be used (lambda expressions rules)
                            final int number = k;
                            blockBuffer.removeIf(element -> element == number);
                        }
                        break;
                    case 1:
                        for(int k = 3; k < 6; k++) {
                            final int number = k;
                            blockBuffer.removeIf(element -> element == number);
                        }
                        break;
                    case 2:
                        for(int k = 6; k < 9; k++) {
                            final int number = k;
                            blockBuffer.removeIf(element -> element == number);
                        }
                        break;
                    default:
                        System.out.println("Error when removing block from blockBuffer");
                        break;
                }
            }
        }
        */

    }
}

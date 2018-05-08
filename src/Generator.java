import java.util.*;

public final class Generator {
    // Returns true if entry is unique in row, column and 3x3-block
    public static boolean checkEntry(int entryRow, int entryColumn){
        // Checks if entry is unique in row
        for(int i = 0; i < 9; i++){
            if(i != entryColumn){
                if(Board.array[entryRow][i] == Board.array[entryRow][entryColumn]){
                    return false;
                }
            }
        }

        // Checks if entry is unique in column
        for(int i = 0; i < 9; i++){
            if(i != entryRow){
                if(Board.array[i][entryColumn] == Board.array[entryRow][entryColumn]){
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
                    if(Board.array[i][j] == Board.array[entryRow][entryColumn]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // TODO: fix numbers being placed in taken squares
    static void fillBoard(){
        Board.reset();

        for(int i = 1; i < 10; i++){
            List<Integer> availableColumns = new LinkedList(Arrays.asList(0,1,2,3,4,5,6,7,8));
            List<Integer> blockBuffer = new ArrayList<>(availableColumns);

            for(int j = 0; j < 9; j++){
                if(j % 3 == 0){
                    blockBuffer = new ArrayList<>(availableColumns);
                }

                int columnIndex = new Random().nextInt(blockBuffer.size());

                Board.addEntry(blockBuffer.get(columnIndex), j, i);
                // Removes the column where entry was added from possible columns
                try {
                    availableColumns.remove(blockBuffer.get(columnIndex));
                } catch (Exception e) {
                    e.printStackTrace();
                }

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

    }
}

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
                if(Board.array[i][j] == Board.array[entryRow][entryColumn]){
                    return false;
                }
            }
        }
        return true;
    }
}

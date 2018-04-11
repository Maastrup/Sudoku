public final class Generator {
    // Returns true if entry is unique in row, column and 3x3-block
    public static boolean checkEntry(Square entry, Square[][] board){
        // Checks if entry is unique in row
        for(int i = 0; i < 9; i++){
            if(board[entry.getRow()][i].getColumn() != entry.getColumn()){
                if(board[entry.getRow()][i].getValue() == entry.getValue()){
                    return false;
                }
            }
        }

        // Checks if entry is unique in column
        for(int i = 0; i < 9; i++){
            if(board[i][entry.getColumn()].getRow() != entry.getRow()){
                if(board[i][entry.getColumn()].getValue() == entry.getValue()){
                    return false;
                }
            }
        }

        // Checks if entry is unique in 3x3-block
        // Square.getBlock()[0] returns column, while Square.getBlock()[1] returns row
        for(int i = entry.getBlock()[0]; i < 3; i++){
            for(int j = entry.getBlock()[1]; i < 3; i++){
                if(board[i][j].getValue() == entry.getValue()){
                    return false;
                }
            }
        }
        return true;
    }
}

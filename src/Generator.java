public static class Generator {
    // Returns true if entry is unique in row, column and 3x3-block
    public static boolean checkEntry(Square entry, Board board){
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

    }
}

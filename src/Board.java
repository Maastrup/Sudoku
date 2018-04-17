public class Board {
    public static Square[][] array = new Square[9][9];

    public static void addEntry(int row, int column, char value){
        int intValue = value - 48;
        array[row][column].setValue(intValue);
    }

    public void resetBoard() {
        array = new Square[9][9];
    }
}

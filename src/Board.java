public class Board {
    public static int[][] array = new int[9][9];

    public static void addEntry(int row, int column, char value){
        int intValue = value - 48;
        array[row][column] = intValue;
    }

    public void resetBoard() {
        array = new int[9][9];
    }
}

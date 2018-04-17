import java.util.Arrays;

public class Board {
    static int[][] array = new int[9][9];

    static void addEntry(int row, int column, char value){
        int intValue = value - 48;
        array[row][column] = intValue;
    }

    static void resetBoard() {
        array = new int[9][9];
    }

    static void print() {
        System.out.println(Arrays.deepToString(array));
    }
}

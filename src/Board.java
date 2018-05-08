import java.util.Arrays;

public class Board {
    static int[][] array = new int[9][9];

    static boolean isEmpty(int column, int row){
        return array[row][column] == 0;
    }

    static void addEntry(int column, int row, char value){
        int intValue = value - 48;
        array[row][column] = intValue;
    }

    static void addEntry(int column, int row, int value){
        array[row][column] = value;
    }

    static void reset() {
        array = new int[9][9];
    }

    static void print() {
        for(int i = 0; i < 9; i++){
            System.out.println(Arrays.toString(array[i]));
        }
    }
}

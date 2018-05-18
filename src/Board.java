import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private int[][] array = new int[9][9];

    public boolean isEmpty(int column, int row){
        // Remember this is a conditional statement!
        boolean test = (this.getValueAt(column, row) == -1);
        return test;
    }

    public void addEntry(int column, int row, char value){
        int intValue = value - 48;
        array[row][column] = intValue;
    }

    public void addEntry(int column, int row, int value){
        array[row][column] = value;
    }

    public void print() {
        for(int i = 0; i < 9; i++){
            if(i % 3 == 0){
                System.out.println(" *-----------------------*");
            }
            for(int j = 0; j < 9; j++){
                if(j % 3 == 0){
                    if (this.isEmpty(j, i)) {
                        System.out.printf("|   ");
                    } else {
                        // %2d gives value the space of 2 characters one is a space
                        System.out.printf(" |%2d", this.getValueAt(j, i));
                    }
                } else {
                    if (this.isEmpty(j, i)) {
                        System.out.printf("  ");
                    } else {
                        System.out.printf("%2d", this.getValueAt(j, i));
                    }
                }
            }
            System.out.printf(" |\n");
        }
        System.out.println(" *-----------------------*");
    }

    public void reset(){
        array = new int[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                this.addEntry(j, i, -1);
            }
        }
    }

    public int getValueAt(int column, int row){
        return array[row][column];
    }

    public void fillWithPlaceHolders(){
        for(int i = 0; i < 9; i++){
            int placeHolder = 0;
            for(int j = 0; j < 9; j++){
                this.addEntry(j, i, placeHolder);
                placeHolder++;
            }
        }
    }

    // Gets blocked columns from gameBoard and available columns from availableBoard
    public ArrayList<Integer> getColumns(int row){
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            if(!(this.isEmpty(i, row))){
                array.add(i);
            }
        }
        return array;
    }

    public void emptyColumn(int column){
        for(int i = 0; i < 9; i++){
            this.addEntry(column, i, -1);
        }
    }

    public void emptyBlockAt(int column, int row){
        // This works! 'column' is an integer and result is therefore truncated
        // right after the math operation and before being multiplied by 3
        int startColumn = column / 3 * 3;
        int startRow = row / 3 * 3;

        for(int i = startRow; i < startRow + 3; i++){
            for(int j = startColumn; j < startColumn + 3; j++){
                this.addEntry(j, i, -1);
            }
        }
    }
}

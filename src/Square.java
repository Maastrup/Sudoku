public class Square {
    private int value;
    boolean hasValue = false;
    private int row;
    private int column;

    Square(int row, int column, int value){
        this.value = value;
        this.row = row;
        this.column = column;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    public int[] getBlock(){
        int blockRow = (int)(Math.floor(row / 3));
        int blockColumn = (int)(Math.floor(column / 3));
        return new int[]{ blockColumn, blockRow };
    }
}

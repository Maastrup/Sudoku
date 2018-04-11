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

    // Ved ikke den skal bruges endnu
    /*
     * public int getBlock(){
     *
     * }
     */
}

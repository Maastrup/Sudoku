public class Game {

    public static void main(String[] args){

        char test = '4';
        Board.addEntry(1,0, test);
        Board.addEntry(0, 5, '4');

        Board.print();

        Generator.fillBoard();

        System.out.println();
        Board.print();
    }
}

public class Game {

    public static void main(String[] args){
        Board gameBoard = new Board();

        Generator.generate(gameBoard);
        gameBoard.print();
    }
}

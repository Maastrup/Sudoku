public class Game {

    public static void main(String[] args){
        Board gameBoard = new Board();

        // Tries to generate af board until a valid one emerges
        boolean boardInProgress = true;
        while(boardInProgress) {
            try {
                Generator.generate(gameBoard);
            } catch (Exception e) {
                //e.printStackTrace();
                continue;
            }

            boardInProgress = false;
        }
        gameBoard.print();

        // Generator.generate(gameBoard);
    }
}

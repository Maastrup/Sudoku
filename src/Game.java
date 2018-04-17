import java.lang.reflect.Array;

public class Game {

    public static void main(String[] args){
        char test = '4';
        Board.addEntry(0,0, test);
        Board.addEntry(0, 5, '4');

        Board.print();

        boolean gTest = Generator.checkEntry(0, 5);
        System.out.println(gTest);
    }
}

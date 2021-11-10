import utils.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int curpla = 1;

        Board board = new Board(24);
        Cup cup = new Cup(board,6);

        board.createPlayers(board.getPlayerAmount());
        board.setPlayers(board.getBruh());
        board.setNames(board.getBruh());
        if (board.getGui_player(1).getName().equals("sus")){
            for (int i = 1; i < board.boardLenght(); i++) {
                board.setOwner(board.getGui_player(1),i);
            }
        }
        for (int i = 0; i < 20; i++) {
            turn(curpla,board,cup);
            curpla++;
            if (curpla==board.getBruh()+1){
                curpla=1;
            }
        }


        board.message(String.valueOf(board.getLocation(board.getGui_player(1))));

    }
    public static void turn(int player,Board board, Cup cup) throws InterruptedException {
        board.movePlayer(board.getGui_player(player), cup.rollCup());

    }

}

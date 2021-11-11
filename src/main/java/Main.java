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
            for (int i = 1; i < board.boardLength(); i++) {
                board.setOwner(board.getGui_player(1),i);
            }
        }
        board.setOwner(board.getGui_player(1),7 );
        turn(curpla,board,cup);


//        for (int i = 0; i < 2; i++) {
//            turn(curpla,board,cup);
//            curpla++;
//            if (curpla==board.getBruh()+1){
//                curpla=1;
//            }
//        }


    }
    public static void turn(int player,Board board, Cup cup) throws InterruptedException {
        board.movePlayer(board.getGui_player(player), 7);
        if (board.getOwned(board.getLocation(board.getGui_player(player)))){
            board.message("abekat");
            //Some code that gives the possibility to buy the field.
        } else{
            board.message("you can buy this");
            //Some code to make the player pay the debt to the other player, or whatever action that happens.
        }


    }

}

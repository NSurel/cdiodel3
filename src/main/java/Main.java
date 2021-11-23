import utils.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        PlayerController players = new PlayerController();
        Board board = new Board(24);
        Cup cup = new Cup(6);

        board.createPlayers(board.setPlayerAmount());
        board.setPlayers(board.getPlayerCount());
        board.setNames(board.getPlayerCount());

        while (gaming(board)){
            players.setCurrentPlayer();
        }



    }
    public static void turn(int player,Board board, Cup cup) throws InterruptedException {
        board.movePlayer(board.getGui_player(player), cup.rollCup());
        if (board.getOwned(board.getLocation(board.getGui_player(player)))){
            board.message("Pay the court a fine or serve your sentence");
            board.payFine(board.getGui_player(player));
            //Some code that gives the possibility to buy the field.
        } else{
            board.message("you can buy this");
            board.buyField(board.getGui_player(player));
            //Some code to make the player pay the debt to the other player, or whatever action that happens.
        }
    }
    public static boolean gaming(Board board){
        boolean gaming = true;
        for (int i = 1; i < board.getPlayerCount()+1; i++) {
            if (board.getGui_player(i).getBalance()<=0){
                gaming = false;
            }
        }
        return gaming;
    }

}

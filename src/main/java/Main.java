import utils.*;

public class Main {

    public static void main(String[] args){
        /*int curpla = 1;

        Board board = new Board(24);
        Cup cup = new Cup(board,6);

        board.createPlayers(board.setPlayerAmount());
        board.setPlayers(board.getPlayerCount());
        board.setNames(board.getPlayerCount());

        while (gaming(board)){
            turn(curpla,board,cup);
            curpla++;
            if (curpla==board.getPlayerCount()+1){
                curpla=1;
            }
        }
        */
        Field[] Hello = new Field[2];
        Property hell02 = new Property("hell" ,"din mor", 2, "Din far");
        Hello[0]= hell02;
        System.out.println(Hello[0].getRent());
        //TODO
        // Make a method that instanciates the fields
        //      (start with the properties and jail
        //



    }
    //todo
    // fix turn method to work with the other classes and not just the gui class
    public static void turn(int playernum,Board board, Cup cup,Player player) {
        board.movePlayer(player ,board.getGui_player(playernum), cup.rollCup());
        if (board.getOwned(board.getLocation(board.getGui_player(playernum)))){
            board.message("Pay the court a fine or serve your sentence");
            board.payFine(board.getGui_player(playernum));
            //Some code that gives the possibility to buy the field.
        } else {
            board.message("you can buy this");
            board.buyField(board.getGui_player(playernum));
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

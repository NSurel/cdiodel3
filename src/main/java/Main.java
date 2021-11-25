import utils.*;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
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
        //test af fields initialize
        /*FieldController Fields = new FieldController();
        FieldController.initializeFields(Fields);
        for (int i = 0; i < 24; i++) {
            System.out.println(Fields.getFields()[i].getName());
        }*/

        //TODO
        //  Make a method that instanciates the fields
        //   (start with the properties and jail)
        //



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

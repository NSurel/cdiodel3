import utils.*;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FieldController fieldController = new FieldController();
        Board board = new Board(24,fieldController.getFields());
        PlayerController playerController = new PlayerController();
        Cup cup = new Cup(6);
        playerController.CreatePLayers(board);

        while (gaming(board)){
        turn(playerController,board,cup);
        }

        //board.createPlayers(board.setPlayerAmount());
        //board.setPlayers(board.getPlayerCount());
        //board.setNames(board.getPlayerCount());

        /*Field[] Hello = new Field[2];
        Property hell02 = new Property("hell" ,"din mor", 2, "Din far");
        Hello[0]= hell02;
        System.out.println(Hello[0].getRent());*/
        //TODO
        // Make a method that instanciates the fields
        //      (start with the properties and jail
        //



    }
    //todo
    // fix turn method to work with the other classes and not just the gui class
    public static void turn(PlayerController playerController,Board board, Cup cup) {
        board.movePlayer(playerController.getCurrentPlayer() ,board.getGui_player(playerController.getCurrentPlayer().getPlayerNum()), cup.rollCup());
        if (board.getOwned(board.getLocation(board.getGui_player(playerController.getCurrentPlayer().getPlayerNum())))){
            board.message("Pay the court a fine or serve your sentence");
            board.payFine(board.getGui_player(playerController.getCurrentPlayer().getPlayerNum()));
            //Some code that gives the possibility to buy the field.
        } else {
            board.message("you can buy this");
            board.buyField(board.getGui_player(playerController.getCurrentPlayer().getPlayerNum()));
            //Some code to make the player pay the debt to the other player, or whatever action that happens.
        }
        playerController.setCurrentPlayer();
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

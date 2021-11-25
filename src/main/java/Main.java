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
        board.msg("The order of the players are the youngest first, and the oldest last");
        board.displayChancecard("test");
        playerController.CreatePLayers(board);

        while (gaming(board,playerController)){
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
        playerController.getCurrentPlayer().updatePos(playerController.getCurrentPlayer(), cup.rollCup());
        board.moveGui_Player(playerController.getCurrentPlayer() ,board.getGui_player(playerController.getCurrentPlayer().getPlayerNum()), cup.getDie1().getFacevalue());
        board.getGui_player(playerController.getCurrentPlayer().getPlayerNum()).setBalance(playerController.getCurrentPlayer().getAccount().getBalance());
        board.msg(String.valueOf(playerController.getCurrentPlayer().getPlayerNum()));
        playerController.setCurrentPlayer();
    }
    public static boolean gaming(Board board,PlayerController playerController){
        boolean gaming = true;
        for (int i = 1; i <playerController.getPlayerAmount()+1 ; i++) {
            if (playerController.getCurrentPlayer().getAccount().getBalance()<=0){
                gaming = false;
            }
        }
        return gaming;
    }

}

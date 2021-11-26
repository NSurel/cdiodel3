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
        ChanceDeck chanceDeck = new ChanceDeck();
        Cup cup = new Cup(6);
        board.msg("The order of the players are the youngest first, and the oldest last");
        board.displayChancecard("test");
        playerController.CreatePLayers(board);

        while (gaming(playerController)){
        turn(playerController,fieldController,board,cup,chanceDeck);
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
    public static void turn(PlayerController playerController, FieldController fieldController,Board board, Cup cup, ChanceDeck chanceDeck) {
        playerController.getCurrentPlayer().updatePos(playerController.getCurrentPlayer(), cup.rollCup());
        board.moveGui_Player(playerController.getCurrentPlayer() ,board.getGui_player(playerController.getCurrentPlayer().getPlayerNum()), cup.getDie1().getFacevalue());
        board.getGui_player(playerController.getCurrentPlayer().getPlayerNum()).setBalance(playerController.getCurrentPlayer().getAccount().getBalance());
        board.msg(String.valueOf(playerController.getCurrentPlayer().getPlayerNum()));

        doFieldAction(fieldController, playerController, chanceDeck, board);

        playerController.setCurrentPlayer();
    }

    private static void doFieldAction(FieldController fieldController, PlayerController playerController, ChanceDeck chanceDeck, Board board)
    {
        Field currentField = fieldController.getFields().get(playerController.getCurrentPlayer().getPos());
        switch (currentField.getFieldType())
        {
            case "Property":
                Property currentProperty = (Property) currentField;
                currentProperty.landedOn(chanceDeck, playerController, board);
            break;
            case "ChanceField":
                ChanceField currentChanceField = (ChanceField)currentField;
                currentChanceField.landedOn(chanceDeck, playerController, board);
            break;
        }
    }

    public static boolean gaming(PlayerController playerController){
        boolean gaming = true;
        for (int i = 1; i < playerController.getAllPlayers().size(); i++) {
            if (playerController.getAllPlayers().get(i-1).getAccount().getBalance()<=0){
                gaming = false;
            }
        }
        return gaming;
    }
}

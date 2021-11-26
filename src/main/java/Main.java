import utils.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FieldController fieldController = new FieldController();
        Board board = new Board(24,fieldController.getFields());
        PlayerController playerController = new PlayerController();
        ChanceDeck chanceDeck = new ChanceDeck();
        Cup cup = new Cup(6);
        board.msg("The order of the players are: the youngest first, and the oldest last");
        playerController.CreatePLayers(board);

        while (gameOngoing(playerController)){
        turn(playerController,fieldController,board,cup,chanceDeck);
        }

        board.msg(findLosingPlayer(playerController).getName() + " has gone bankrupt");
        board.msg(findWinningPlayer(playerController).getName() + " is the winner of the game!!");
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
        board.rollMsg();
        playerController.getCurrentPlayer().updatePos(cup.rollCup(), board);
        board.setDie(cup.getDie1().getFacevalue());
        //board.moveGui_Player(playerController.getCurrentPlayer());
        //board.getGui_player(playerController.getCurrentPlayer().getPlayerNum()).setBalance(playerController.getCurrentPlayer().getAccount().getBalance());

        doFieldAction(fieldController, playerController, chanceDeck, board);
        //hasJailCard(playerController,board);
        updateOwners(fieldController,board);
        board.updateGuiPlayers(playerController);
        board.msg("It is now " + playerController.getCurrentPlayer().getName() +"'s turn");
        playerController.setCurrentPlayer();

    }

    private static void doFieldAction(FieldController fieldController, PlayerController playerController, ChanceDeck chanceDeck, Board board)
    {
        Field currentField = fieldController.getFields().get(playerController.getCurrentPlayer().getPos());
        currentField.landedOn(chanceDeck, playerController, board);
        /*switch (currentField.getFieldType())
        {
            case "Property":
                Property currentProperty = (Property) currentField;
                currentProperty.landedOn(chanceDeck, playerController, board);
            break;
            case "ChanceField":
                ChanceField currentChanceField = (ChanceField)currentField;
                currentChanceField.landedOn(chanceDeck, playerController, board);
            break;
        }*/
    }

    public static boolean gameOngoing(PlayerController playerController){
        boolean gaming = true;
        for (int i = 1; i < playerController.getAllPlayers().size(); i++) {
            if (playerController.getAllPlayers().get(i-1).getAccount().getBalance()<=0){
                gaming = false;
            }
        }
        return gaming;
    }
    //fix this, it is trash
    /*public static void hasJailCard(PlayerController playerController, Board board){
        if (playerController.getCurrentPlayer().GetGetoutofjailfreecard()&&!board.getGui_player(playerController.getCurrentPlayer().getPlayerNum()).getName().equals(playerController.getCurrentPlayer().getName()+" *")){
            board.getGui_player(playerController.getCurrentPlayer().getPlayerNum()).setName(board.getGui_player(playerController.getCurrentPlayer().getPlayerNum()).getName() + " *");
        }
        if (!playerController.getCurrentPlayer().GetGetoutofjailfreecard()&&!board.getGui_player(playerController.getCurrentPlayer().getPlayerNum()).getName().equals(playerController.getCurrentPlayer().getName()+" *")){
            board.getGui_player(playerController.getCurrentPlayer().getPlayerNum()).setName(board.getGui_player(playerController.getCurrentPlayer().getPlayerNum()).getName());
        }
    }*/
    public static void updateOwners(FieldController fieldController, Board board){
        for (int i = 0; i <fieldController.getFields().size() ; i++) {
            if (fieldController.getFields().get(i).getFieldType().equals("Property")&&fieldController.getFields().get(i).getOwner()!=null){
                //board.getownableFields()[i].setOwnerName(fieldController.getFields().get(i).getOwner().getName());
                board.getownableFields()[i].setBorder(board.getGui_player(fieldController.getFields().get(i).getOwner().getPlayerNum()).getPrimaryColor());
            }
        }
    }

    public static Player findWinningPlayer(PlayerController playerController)
    {
        Player winningPLayer = new Player("No one",404);
        for (Player p : playerController.getAllPlayers() ) {
            Player fp = playerController.getAllPlayers().get(0);
            if (p.getAccount().getBalance() > fp.getAccount().getBalance() && p.getAccount().getBalance() > winningPLayer.getAccount().getBalance()){
                winningPLayer = p;
            }
        }
        return winningPLayer;
    }

    public static Player findLosingPlayer(PlayerController playerController)
    {
        Player losingPlayer = new Player("No one",404);
        for (Player p : playerController.getAllPlayers() ) {
            if (p.getAccount().getBalance()<=0){
                losingPlayer = p;
            }
        }
        return losingPlayer;
    }

}

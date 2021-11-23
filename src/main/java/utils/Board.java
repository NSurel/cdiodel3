package utils;

import gui_fields.*;
import gui_main.GUI;
import java.awt.*;

public class Board {

    //todo
    // change order of methods, to make more sense and make it more readable.
    // Change methods to be ready for controllers input to the GUI
    private GUI gui;
    private GUI_Field[] fields;
    private int playerCount;
    GUI_Car car0 = new GUI_Car(Color.RED, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
    GUI_Car car1 = new GUI_Car(Color.BLUE, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
    GUI_Car car2 = new GUI_Car(Color.PINK, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
    GUI_Car car3 = new GUI_Car(Color.YELLOW, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
    GUI_Player gui_player1;
    GUI_Player gui_player2;
    GUI_Player gui_player3;
    GUI_Player gui_player4;
    GUI_Player[] maxplayers = new GUI_Player[4];
    GUI_Ownable[] fieldsOwned;
    GUI_Player[] players;

    public Board(int size){
        //todo
        // make a GUI_Field[] that matches the actual game one
        // with correspondings titles, subtexts, and backgroundcolors
        fields = new GUI_Field[size];
        Color color = new Color(74,204,84);
        for (int i = 0; i < fields.length; i++) {
            GUI_Street test = new GUI_Street();
            fields[i] = test;
        }
        fieldsOwned = new GUI_Ownable[size];
        for (int i = 0; i < fieldsOwned.length; i++) {
            fieldsOwned[i] = (GUI_Ownable) fields[i];
        }
        fields[1].setBackGroundColor(Color.RED);
        fields[2].setBackGroundColor(Color.RED);
        gui = new GUI(fields,color);
    }

    public void message(String msg){
        gui.showMessage(msg);
    }

    public String getPlayerName(String playerAndNumber){
        return gui.getUserString(playerAndNumber + " please type in your name");
    }
    public int setPlayerAmount(){
        //playerAmount = gui.getUserInteger("How many players?");
         int playerAmount = Integer.valueOf(gui.getUserSelection("how many players?", "2", "3", "4"));
        return playerAmount;
    }

    //todo
    // work with Player class and Field classes instead
    // and with the input from them change the border color of GUI_Fields
    public void setOwner(GUI_Player player, int i){
        fieldsOwned[i].setBorder(player.getPrimaryColor());
        fieldsOwned[i].setOwnerName(player.getName());
    }

    public boolean getOwned(int i){
        if (fieldsOwned[i].getOwnerName()==null){
            return false;
        } else{
            return true;
        }
    }
    public void createPlayers(int amount)   {
        playerCount = amount;
        gui_player1 = new GUI_Player("Player1",35,car0);
        gui_player2 = new GUI_Player("Player2",35,car1);
        gui_player3 = new GUI_Player("Player3",35,car2);
        gui_player4 = new GUI_Player("Player4",35,car3);
        maxplayers[0] = gui_player1;
        maxplayers[1] = gui_player2;
        maxplayers[2] = gui_player3;
        maxplayers[3] = gui_player4;
        for (int i = 0; i < amount; i++) {
            gui.addPlayer(maxplayers[i]);
            fields[0].setCar(maxplayers[i],true );
        }
    }
    //todo
    // change to find the Player's location and not GUI_Player
    public int getLocation(GUI_Player player){
        int i = 0;
        while(!fields[i].hasCar(player)){
            i++;
        }
        return i;
    }
    public int getPlayerCount(){
        return playerCount;
    }

    //todo
    //
    public void setNames(int amount){
        for (int i = 1; i < amount+1; i++) {
            players[i-1].setName(getPlayerName("player "+i));
        }
    }
    //todo
    // change this method, its unnecessary. Just move piece from current location to new location.
    //
    public void movePlayer(GUI_Player player,int spaces) throws InterruptedException {
        gui.setDie(spaces);
        int currentfield = getLocation(player);
        int steps = currentfield+spaces;
        fields[currentfield].setCar(player,false);
        for (int i = currentfield; i <steps ; i++) {
            fields[i].setCar(player,false);
            Thread.sleep(500L);
            if(i==23){
                fields[0].setCar(player,true);
                i = 0;
                steps -= 24;
                Thread.sleep(500L);
                fields[i].setCar(player,false);
                Thread.sleep(500L);
                fields[i+1].setCar(player,true);
            }else {
                fields[i + 1].setCar(player, true);
            }
            Thread.sleep(500L);
        }
    }

    public void setPlayers(int i){
        players = new GUI_Player[i];
        for (int j = 0; j < i; j++) {
            players[j] = maxplayers[j];
        }
    }
    public GUI_Player getGui_player(int player){

        return players[player-1];
    }

    //todo
    // should work with the Field classes instead
    public void buyField(GUI_Player player){
        String userInput = gui.getUserSelection("Do you want to buy this field?","Yes","No");
        if (player.getBalance()>=3){
            if (userInput.equals("Yes")){
                setOwner(player,getLocation(player));
                player.setBalance(player.getBalance()-3);
            } else{
                message("Ok weirdo");
            }
        }else {
            message("You don't have the funds to buy this");
        }


    }

    //todo
    // should also work with the Field classes
    public GUI_Player findOwner(int i){
        int owner = 0;
        for (int j = 0; j < getPlayerCount(); j++) {

            if(fieldsOwned[i].getOwnerName().equals(players[j].getName())){
                owner = j;
            }
        }
        return players[owner];
    }
    //todo
    // work with Player class and Account class instead
    public void payFine(GUI_Player unlucky){
        if (!fieldsOwned[getLocation(unlucky)].getOwnerName().equals(unlucky.getName())){
            findOwner(getLocation(unlucky)).setBalance(findOwner(getLocation(unlucky)).getBalance()+3);
            unlucky.setBalance(unlucky.getBalance()-3);
        }else{
            message("You own this field");
        }
    }
}

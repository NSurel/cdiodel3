package utils;

import gui_fields.*;
import gui_main.GUI;
import java.awt.*;

public class Board {
    private GUI gui;
    private GUI_Field[] fields;
    private int bruh;
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
    public int getPlayerAmount(){
        //playerAmount = gui.getUserInteger("How many players?");
         int playerAmount = Integer.valueOf(gui.getUserSelection("how many players?", "2", "3", "4"));
        return playerAmount;
    }
    public void setOwner(GUI_Player player, int i){
        //GUI_Ownable o;
        //o = (GUI_Ownable) fields[i];
        //o.setBorder(player.getPrimaryColor());
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
        bruh = amount;
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
    public int boardLenght(){
        return fields.length;
    }
    public void setCar(int field, GUI_Player player){
        fields[field].setCar(player, true);
    }
    public void removeCar(int field, GUI_Player player){
        fields[field].setCar(player, false);
    }
    public int getLocation(GUI_Player player){
        int i = 0;
        while(!fields[i].hasCar(player)){
            i++;
        }
        return i;
    }
    public int getBruh(){
        return bruh;
    }
    public void setNames(int amount){
        for (int i = 1; i < amount+1; i++) {
            players[i-1].setName(getPlayerName("player "+i));
        }
        /*
        switch (amount){
            case 2:
                gui_player1.setName(getPlayerName("player 1"));
                gui_player2.setName(getPlayerName("player 2"));
                break;
            case 3:
                gui_player1.setName(getPlayerName("player 1"));
                gui_player2.setName(getPlayerName("player 2"));
                gui_player3.setName(getPlayerName("player 3"));
                break;
            case 4:
                gui_player1.setName(getPlayerName("player 1"));
                gui_player2.setName(getPlayerName("player 2"));
                gui_player3.setName(getPlayerName("player 3"));
                gui_player4.setName(getPlayerName("player 4"));
                break;
        }

         */
    }
    public void movePlayer(GUI_Player player,int spaces) throws InterruptedException {
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
    public void setDice(int dice1, int dice2){
        gui.setDice(dice1,9,2,dice2,10,2);
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
}
